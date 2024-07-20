package cl.nescorp.provider.aplication.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.nescorp.provider.aplication.dto.MecanismoCompraDTO;
import cl.nescorp.provider.aplication.service.MecanismoCompraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class MecanismoCompraController {
	
	private final MecanismoCompraService service;

	@GetMapping(path = "/findAll", consumes = "application/json; charset=utf-8")
	public ResponseEntity<List<MecanismoCompraDTO>> register() {
		return ResponseEntity.ok(service.findAll());
	}

}
