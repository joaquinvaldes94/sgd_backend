package cl.nescorp.provider.aplication.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.nescorp.provider.aplication.dto.MonedaDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.dto.SolicitudRequest;
import cl.nescorp.provider.aplication.service.SolicitudService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/solicitud")
@RequiredArgsConstructor
public class SolicitudController {
	
	private final SolicitudService solicitudService;


	@PostMapping(path = "/createNew", consumes = "application/json; charset=utf-8")
	public ResponseDTO create(@RequestBody SolicitudRequest request) {
		return solicitudService.create(request);
	}
	
	@GetMapping(path = "/findAll", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO findAll() {
		return solicitudService.findAll();
	}

	@GetMapping(path = "/findById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseDTO findById(@PathVariable("id") String id) {
		return solicitudService.findById(id);
	}
	
	
}
