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

	@GetMapping(value="/pruebaApp",produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

}
