package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.IndicePresupuestarioDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.entity.IndicePresupuestario;
import cl.nescorp.provider.aplication.repository.IndicePresupuestarioRepository;
import cl.nescorp.provider.aplication.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndicePresupuestarioService {

	private final IndicePresupuestarioRepository indiceRepository;

	public ResponseDTO findAll() {

		List<IndicePresupuestarioDTO> dtoList = new ArrayList<>();
		List<IndicePresupuestario> listAll = indiceRepository.findAll();

		listAll.forEach(mc -> {
			dtoList.add(new IndicePresupuestarioDTO(mc));

		});
		return new ResponseDTO(HttpStatus.OK, dtoList);

	}

	public ResponseDTO findById(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			IndicePresupuestario ip = indiceRepository.findById(Long.valueOf(id)).orElse(new IndicePresupuestario());
			return new ResponseDTO(HttpStatus.OK, new IndicePresupuestarioDTO(ip));
		}
	}

	public ResponseDTO save(IndicePresupuestarioDTO request) {

		IndicePresupuestario ip = new IndicePresupuestario();
		ip.setNombre(request.getNombre());
		ip.setSubtitulo(request.getSubtitulo());
		ip.setItem(request.getItem());
		ip.setAsignacion(request.getAsignacion());
		ip.setDescripcion(request.getDescripcion());
		ip.setFechaCreacion(Utils.findDateTimeNow());
		ip = indiceRepository.save(ip);
		return new ResponseDTO(HttpStatus.OK, ip.getId());
	}

	public ResponseDTO update(IndicePresupuestarioDTO request) {
		if (null == request.getId()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			IndicePresupuestario ip = indiceRepository.findById(request.getId()).orElse(null);
			if (null == ip) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
				ip.setNombre(request.getNombre());
				ip.setSubtitulo(request.getSubtitulo());
				ip.setItem(request.getItem());
				ip.setAsignacion(request.getAsignacion());
				ip.setDescripcion(request.getDescripcion());
				ip = indiceRepository.save(ip);
				return new ResponseDTO(HttpStatus.OK, new IndicePresupuestarioDTO(ip));
			}
		}
	}

	public ResponseDTO delete(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			indiceRepository.deleteById(Long.valueOf(id));
			return new ResponseDTO(HttpStatus.OK, new IndicePresupuestarioDTO());
		}
	}
}
