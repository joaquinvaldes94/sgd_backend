package cl.nescorp.provider.aplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.nescorp.provider.aplication.config.JwtService;
import cl.nescorp.provider.aplication.dto.AuthenticationRecoveryPassword;
import cl.nescorp.provider.aplication.dto.AuthenticationRequest;
import cl.nescorp.provider.aplication.dto.AuthenticationResponse;
import cl.nescorp.provider.aplication.dto.RegisterRequest;
import cl.nescorp.provider.aplication.entity.LoginHistory;
import cl.nescorp.provider.aplication.entity.Token;
import cl.nescorp.provider.aplication.entity.TokenType;
import cl.nescorp.provider.aplication.entity.Usuario;
import cl.nescorp.provider.aplication.repository.LoginHistoryRepository;
import cl.nescorp.provider.aplication.repository.TokenRepository;
import cl.nescorp.provider.aplication.repository.UsuarioRepository;
import cl.nescorp.provider.aplication.util.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UsuarioRepository repository;
	private final TokenRepository tokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final LoginHistoryRepository loginRepository;
	private final EmailService emailService;
	private final UserDetailsService userDetailsService;

	public AuthenticationResponse register(RegisterRequest request) {
		var user = Usuario.builder().correo(request.getCorreo()).password(passwordEncoder.encode("contraseña"))
				.estado(1).fechaCreacion(Utils.findDateTimeNow()).dni(Integer.parseInt(request.getDni()))
				.role(request.getRole()).build();
		var savedUser = repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(user);
		saveUserToken(savedUser, jwtToken);
		return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) throws Throwable {
		Boolean validate = false;
		Usuario user = null;

		try {
			validate = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getRut(), request.getPassword()))
					.isAuthenticated();

			if (validate) {

				user = repository.findByDni(Integer.parseInt(request.getRut())).orElseThrow();
				String messagge = "Welcome " + user.getCorreo();
				loginRepository.save(LoginHistory.builder().usuario(user).validate(true).build());
				Long countSession = loginRepository.countByUsuarioIdAndValidate(user.getId(), true);
				if (countSession == 1) {
					messagge = "Cambia tu password Aquí!! www.nescorp.cl/sisbuy/changeFirstPass";
				}
				String jwtToken = jwtService.generateToken(user);
				var refreshToken = jwtService.generateRefreshToken(user);
				revokeAllUserTokens(user);
				saveUserToken(user, jwtToken);
				return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken)
						.message(messagge).build();
			}
		} catch (BadCredentialsException e) {
			user = repository.findByDni(Integer.parseInt(request.getRut())).orElse(null);
			if (null == user) {
				return new AuthenticationResponse(null, null, "Usuario no creado !!!");
			} else if (null == request.getPassword()) {
				return new AuthenticationResponse(null, null, "Error contraseña ilegible!!!");
			} else {
				String intentos = loginFailUsuario(user);
				return new AuthenticationResponse(null, null, "Contraseña erronea !!! " + intentos);
			}
		} catch (LockedException e) {
			return new AuthenticationResponse(null, null, "Cuenta Bloqueada Comuniquese con Soporte !!! ");
		} catch (AuthenticationException e) {
			return new AuthenticationResponse(null, null, "Tu Solicitud de authenticación es erronea !!!");
		}

		throw new Exception("Falla en autenticación");

	}

	private String loginFailUsuario(Usuario user) {
		Long intentos = null;
		String mensaje = "";
		loginRepository.save(LoginHistory.builder().usuario(user).validate(false).build());
		LoginHistory lastLoginSuccess = loginRepository
				.findFirstByUsuarioIdAndValidateOrderByFechaCreacionDesc(user.getId(), true);
		if (null == lastLoginSuccess) {
			intentos = loginRepository.countByUsuarioIdAndValidate(user.getId(), false);

		} else {
			intentos = loginRepository.countByUsuarioIdAndValidateAndIdIsGreaterThan(user.getId(), false,
					lastLoginSuccess.getId());
		}
		if (intentos == 4) {
			user.setEstado(3);
			repository.save(user);
			mensaje = "Cuenta bloqueada!";
		}

		return "Intentos realizados fallidos N°" + intentos + ". " + mensaje;
	}

	private void saveUserToken(Usuario user, String jwtToken) {
		var token = Token.builder().usuario(user).token(jwtToken).tokenType(TokenType.BEARER).expirado(false)
				.revocado(false).build();
		tokenRepository.save(token);
	}

	private void revokeAllUserTokens(Usuario user) {
		var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpirado(true);
			token.setRevocado(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}

	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		final String refreshToken;
		final String userEmail;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		refreshToken = authHeader.substring(7);
		userEmail = jwtService.extractUsername(refreshToken);
		if (userEmail != null) {
			var user = this.repository.findByDni(Integer.parseInt(userEmail)).orElseThrow();
			if (jwtService.isTokenValid(refreshToken, user)) {
				var accessToken = jwtService.generateToken(user);
				revokeAllUserTokens(user);
				saveUserToken(user, accessToken);
				var authResponse = AuthenticationResponse.builder().accessToken(accessToken).refreshToken(refreshToken)
						.build();
				new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
			}
		}
	}

	public String recoveryPassword(AuthenticationRecoveryPassword request) {
		Boolean validate = !request.getCorreo().isEmpty() && !request.getRut().isEmpty() ? true : false;

		Usuario user = null;
		if (validate) {
			user = repository.findByDniAndCorreo(Integer.parseInt(request.getRut()), request.getCorreo()).orElse(null);
			if (null == user) {
				return "Datos ingresados no validos!!!";
			} else {
				// enviar correo
				Map<String, Object> map1 = new HashMap();
				map1.put("iss", user.getCorreo());
				String token = jwtService.buildToken(map1, user, 500000);
				// emailService.sendEmail("contacto.droness@gmail.com", "Soporte@sporte.cl",
				// token);
				return "Link:" + token;
			}
		}

		return "recuperación de Contraseña incompleta contacte a soporte";
	}

	public String changeFirstPassword(AuthenticationRequest request, HttpServletRequest httpRequest) {
		final String authHeader = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
		final String token;
		final String dni;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return "Token No Valido";
		}
		token = authHeader.substring(7);
		dni = jwtService.extractUsername(token);
		if (dni != null) {
			var user = this.repository.findByDni(Integer.parseInt(dni)).orElseThrow();
			if (jwtService.isTokenValid(token, user) && null != request.getPassword()) {
				user.setPassword(passwordEncoder.encode(request.getPassword()));
				repository.save(user);
				return "contraseña cambiada correctamente";
			}
		} else {
			return "No fue posible validar el token";
		}
		return null;

	}

	public String changeNewPassword(String password, HttpServletRequest request) {

		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String user;
		final String userEmail;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return "No se ha podido completar la solicitud";
		}
		jwt = authHeader.substring(7);

		if (jwt != null) {
			user = jwtService.extractUsername(jwt);
			UserDetails userDetails = userDetailsService.loadUserByUsername(user);
			if (jwtService.isTokenValid(jwt, userDetails)) {
				userEmail = jwtService.extractIssuer(jwt);
				Usuario userFound = repository.findByDniAndCorreo(Integer.parseInt(user), userEmail).orElse(null);
				if (null != userFound) {
					userFound.setPassword(passwordEncoder.encode(password));
					return "Contraseña actualizada correctamente";
				} else {
					return "Token mal generado para cambio de contraseña";
				}

			} else {
				return "El Token generado ha expirado, genere uno nuevo";
			}
			// TODO Auto-generated method stub}
		}
		return "No se pude completar el cambio de contraseña";

	}

}
