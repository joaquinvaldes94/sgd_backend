package cl.nescorp.provider.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration  {

	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	private final LogoutHandler logoutHandler;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.cors(cors -> cors.disable()).csrf(csrf -> csrf.disable()).authorizeHttpRequests(authorizeRequests -> {

			authorizeRequests.requestMatchers("/swagger-ui/**").hasAuthority("ADMIN")
					.requestMatchers(HttpMethod.POST, "/api/v1/auth/register").permitAll()
					.requestMatchers(HttpMethod.POST, "/api/v1/auth/authenticate").permitAll()
					.requestMatchers(HttpMethod.POST, "/api/v1/auth/refresh-token").permitAll()
					.requestMatchers(HttpMethod.POST, "/api/v1/auth/recoveryPassword").permitAll()
					.requestMatchers(HttpMethod.POST, "/api/v1/auth/createNewPassword").permitAll()
					.requestMatchers(HttpMethod.GET, "api/v1/demo-controller/pruebaAppFreeToken").permitAll()
					.anyRequest().authenticated();

		}).sessionManagement(sessionManage -> {
			sessionManage.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}).authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).logout(log -> {
					log.logoutUrl("/api/v1/auth/logout").addLogoutHandler(logoutHandler).logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
				});

		/*
		 * .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(),
		 * MANAGER.name())
		 * 
		 * 
		 * .requestMatchers(GET,
		 * "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(),
		 * MANAGER_READ.name()) .requestMatchers(POST,
		 * "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(),
		 * MANAGER_CREATE.name()) .requestMatchers(PUT,
		 * "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),
		 * MANAGER_UPDATE.name()) .requestMatchers(DELETE,
		 * "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(),
		 * MANAGER_DELETE.name())
		 * 
		 * 
		 * /* .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())
		 * .requestMatchers(GET, "/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
		 * .requestMatchers(POST, "/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
		 * .requestMatchers(PUT, "/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
		 * .requestMatchers(DELETE,
		 * "/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())
		 */

		return http.build();
	}
}
