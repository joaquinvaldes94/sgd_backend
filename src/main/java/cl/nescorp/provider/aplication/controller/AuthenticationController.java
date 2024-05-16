package cl.nescorp.provider.aplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.nescorp.provider.aplication.dto.AuthenticationRecoveryPassword;
import cl.nescorp.provider.aplication.dto.AuthenticationRequest;
import cl.nescorp.provider.aplication.dto.AuthenticationResponse;
import cl.nescorp.provider.aplication.dto.RegisterRequest;
import cl.nescorp.provider.aplication.service.AuthenticationService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

	@PostMapping(path = "/register", consumes = "application/json; charset=utf-8")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
			throws Throwable {
		return ResponseEntity.ok(service.authenticate(request));
	}

	@PostMapping("/refresh-token")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		service.refreshToken(request, response);
	}

	@PostMapping("/recoveryPassword")
	public String recoveryPassword(@RequestBody AuthenticationRecoveryPassword request) {
		return service.recoveryPassword(request);
	}
	
	@PostMapping("/changeNewPassword")
	public String changeNewPassword(@RequestBody String password,HttpServletRequest request) {
		return service.changeNewPassword(password, request);
	}


	@PostMapping(value = "/changeFirstPassword", consumes = "application/json; charset=utf-8", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> changeFirstPassword(@RequestBody AuthenticationRequest request,
			HttpServletRequest httpRequest) {
		return ResponseEntity.ok(service.changeFirstPassword(request, httpRequest));
	}
	

}
