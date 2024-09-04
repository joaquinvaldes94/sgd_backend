package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.MonedaDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.entity.Moneda;
import cl.nescorp.provider.aplication.repository.MonedaRepository;
import cl.nescorp.provider.aplication.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MonedaService {

	private final MonedaRepository monedaRepository;

	public ResponseDTO findAll() {

		List<MonedaDTO> dtoList = new ArrayList<>();
		List<Moneda> listAll = monedaRepository.findAll();
		listAll.forEach(mc -> {
			dtoList.add(new MonedaDTO(mc));
		});
		return new ResponseDTO(HttpStatus.OK, dtoList);
	}

	public ResponseDTO findById(String id) {

		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			Moneda mon = monedaRepository.findById(Long.valueOf(id)).orElse(new Moneda());
			return new ResponseDTO(HttpStatus.OK, new MonedaDTO(mon));
		}
	}

	public ResponseDTO save(MonedaDTO request) {

		Moneda moneda = new Moneda();
		moneda.setNombre(request.getNombre());
		moneda.setDescripcion(request.getNombre());
		moneda.setCodigo(request.getCodigo());
		moneda.setDecimales(request.getDecimales());
		moneda.setFechaCreacion(Utils.findDateTimeNow());
		moneda = monedaRepository.save(moneda);
		return new ResponseDTO(HttpStatus.OK, moneda.getId());
	}

	public ResponseDTO update(MonedaDTO request) {
		if (null == request.getId()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			Moneda moneda = monedaRepository.findById(request.getId()).orElse(null);
			if (null == moneda) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
				moneda.setNombre(request.getNombre());
				moneda.setDescripcion(request.getNombre());
				moneda.setCodigo(request.getCodigo());
				moneda.setDecimales(request.getDecimales());
				moneda = monedaRepository.save(moneda);
				return new ResponseDTO(HttpStatus.OK, new MonedaDTO(moneda));
			}
		}
	}

	public ResponseDTO delete(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			monedaRepository.deleteById(Long.valueOf(id));
			return new ResponseDTO(HttpStatus.OK, new MonedaDTO());
		}
	}

}
