package cl.nescorp.provider.aplication.controller;

import io.swagger.v3.oas.annotations.Hidden;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
@Hidden
public class DemoController {

	@GetMapping(value="/pruebaAppFreeToken",produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<String> sayHello() {
    System.out.println("Hola Nes Corp");
    return ResponseEntity.ok("Hola Nes Corp");
  }

	
	@GetMapping(value="/pruebaApp",produces = {MediaType.APPLICATION_JSON_VALUE})
	  public ResponseEntity<String> sayHelloSecurity() {
	    return ResponseEntity.ok("Hola Nes Corp, desde endPoint con seguridad");
	  }
}
