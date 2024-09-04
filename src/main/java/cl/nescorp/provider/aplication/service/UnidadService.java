package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.dto.UnidadDTO;
import cl.nescorp.provider.aplication.entity.Unidad;
import cl.nescorp.provider.aplication.repository.UnidadRepository;
import cl.nescorp.provider.aplication.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnidadService {

	private final UnidadRepository unidadRepository;

	public ResponseDTO findAll() {

		List<UnidadDTO> dtoList = new ArrayList<>();
		List<Unidad> listAll = unidadRepository.findAll();

		listAll.forEach(mc -> {
			dtoList.add(new UnidadDTO(mc));

		});
		return new ResponseDTO(HttpStatus.OK, dtoList);
	}

	public ResponseDTO findById(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			Unidad un = unidadRepository.findById(Long.valueOf(id)).orElse(new Unidad());
			return new ResponseDTO(HttpStatus.OK, new UnidadDTO(un));
		}
	}

	public ResponseDTO save(UnidadDTO request) {
		Unidad un = new Unidad();
		un.setNombre(request.getNombre());
		un.setDescripcion(request.getDescripcion());
		un.setFechaCreacion(Utils.findDateTimeNow());
		un = unidadRepository.save(un);
		return new ResponseDTO(HttpStatus.OK, un.getId());

	}

	public ResponseDTO update(UnidadDTO request) {
		if (null == request.getId()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			Unidad un = unidadRepository.findById(request.getId()).orElse(null);
			if (null == un) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
				un.setNombre(request.getNombre());
				un.setDescripcion(request.getDescripcion());
				un = unidadRepository.save(un);
				return new ResponseDTO(HttpStatus.OK, new UnidadDTO(un));

			}
		}
	}

	public ResponseDTO delete(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			unidadRepository.deleteById(Long.valueOf(id));
			return new ResponseDTO(HttpStatus.OK, new UnidadDTO());
		}
	}

}
