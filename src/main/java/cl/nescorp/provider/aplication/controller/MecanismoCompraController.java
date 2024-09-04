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

import cl.nescorp.provider.aplication.dto.MecanismoCompraRequestDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.service.MecanismoCompraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/MecanismoCompra")
@RequiredArgsConstructor
public class MecanismoCompraController {

	private final MecanismoCompraService service;

	@GetMapping(path = "/findAll", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO findAll() {
		return service.findAll();
	}
	
	@GetMapping(path = "/findById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseDTO findById(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@PostMapping(path = "/save", consumes = "application/json; charset=utf-8", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseDTO save(@RequestBody MecanismoCompraRequestDTO request ) {
		return service.save(request);
	}
	
	@PutMapping(path = "/update", consumes = "application/json; charset=utf-8", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseDTO update(@RequestBody MecanismoCompraRequestDTO request ) {
		return service.update(request);
	}
	
	@DeleteMapping(path = "/deleteById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseDTO delete(@PathVariable("id") String id ) {
		return service.delete(id);
	}
	
	@GetMapping(path = "/findByClasificacionCompraID/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseDTO findByClasificacionCompraID(@PathVariable("id") String id) {
		return service.findByClasificacionCompraID(id);
	}
	
}
