package cl.nescorp.provider.aplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.nescorp.provider.aplication.dto.AuthenticationRecoveryPassword;
import cl.nescorp.provider.aplication.dto.AuthenticationRequest;
import cl.nescorp.provider.aplication.dto.RegisterRequest;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.service.AuthenticationService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

	@PostMapping(value =  "/register", consumes = "application/json; charset=utf-8")
	public ResponseDTO register(@RequestBody RegisterRequest request) {
		return  new ResponseDTO(HttpStatus.OK,service.register(request));
	}

	@PostMapping(value = "/authenticate", consumes = "application/json; charset=utf-8", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO authenticate(@RequestBody AuthenticationRequest request)
			throws Throwable {
		return service.authenticate(request);
	}

	@PostMapping(value = "/refresh-token", consumes = "application/json; charset=utf-8", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		service.refreshToken(request, response);
	}

	@PostMapping(value = "/recoveryPassword", consumes = "application/json; charset=utf-8", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO recoveryPassword(@RequestBody AuthenticationRecoveryPassword request) {
		return new ResponseDTO(HttpStatus.OK,service.recoveryPassword(request));
	}
	
	@PostMapping(value = "/createNewPassword", consumes = "application/json; charset=utf-8", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO createNewPassword(@RequestBody AuthenticationRecoveryPassword requestBody,HttpServletRequest request) {
		return new ResponseDTO(HttpStatus.OK,service.createNewPassword(requestBody, request));
	}


	@PostMapping(value = "/changePasswordSecured", consumes = "application/json; charset=utf-8", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO changePasswordSecured(@RequestBody AuthenticationRequest request,
			HttpServletRequest httpRequest) {
		return new ResponseDTO(HttpStatus.OK,service.changePasswordSecured(request, httpRequest));
	}
	

}
