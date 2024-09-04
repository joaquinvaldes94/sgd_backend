package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.RequisitoDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.entity.MecanismoCompra;
import cl.nescorp.provider.aplication.entity.Requisito;
import cl.nescorp.provider.aplication.repository.MecanismoCompraRepository;
import cl.nescorp.provider.aplication.repository.RequisitoRepository;
import cl.nescorp.provider.aplication.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequisitoService {

	private final RequisitoRepository requisitoRepo;
	private final MecanismoCompraRepository mecanismoCompraRepo;

	public ResponseDTO findAll() {
		List<RequisitoDTO> dtoList = new ArrayList<>();
		List<Requisito> listAll = requisitoRepo.findAll();
		listAll.forEach(mc -> {
			dtoList.add(new RequisitoDTO(mc));
		});
		return new ResponseDTO(HttpStatus.OK, dtoList);
	}

	public ResponseDTO findById(String id) {

		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			Requisito mc = requisitoRepo.findById(Long.valueOf(id)).orElse(new Requisito());
			return new ResponseDTO(HttpStatus.OK, new RequisitoDTO(mc));
		}
	}

	public ResponseDTO save(RequisitoDTO request) {
		if (null == request.getMecanismoCompraID()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			MecanismoCompra mc = mecanismoCompraRepo.findById(Long.valueOf(request.getId())).orElse(null);
			if (null == mc) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
				Requisito re = new Requisito();
				re.setNombre(request.getNombre());
				re.setCantidad(Integer.parseInt(request.getCantidad()));
				re.setObligatorio(request.getObligatorio().equalsIgnoreCase("true") ? true : false);
				re.setDescripcion(request.getDescripcion());
				re.setExtensiones(request.getExtensiones());
				re.setFormatoBase(request.getFormatoBase());
				re.setFechaCreacion(Utils.findDateTimeNow());
				re.setMecanismoCompra(new MecanismoCompra(Long.valueOf(request.getMecanismoCompraID())));
				re = requisitoRepo.save(re);

				return new ResponseDTO(HttpStatus.OK, re.getId());
			}
		}
	}

	public ResponseDTO update(RequisitoDTO request) {
		if (null == request.getId() || null == request.getMecanismoCompraID()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			Requisito re = requisitoRepo.findById(Long.valueOf(request.getId())).orElse(null);
			MecanismoCompra mc = mecanismoCompraRepo.findById(Long.valueOf(request.getId())).orElse(null);

			if (null == re || null == mc) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
				re.setNombre(request.getNombre());
				re.setCantidad(Integer.parseInt(request.getCantidad()));
				re.setObligatorio(request.getObligatorio().equalsIgnoreCase("true") ? true : false);
				re.setDescripcion(request.getDescripcion());
				re.setExtensiones(request.getExtensiones());
				re.setFormatoBase(request.getFormatoBase());
				re.setMecanismoCompra(new MecanismoCompra(Long.valueOf(request.getMecanismoCompraID())));
				re = requisitoRepo.save(re);
				return new ResponseDTO(HttpStatus.OK, new RequisitoDTO(re));
			}
		}
	}

	public ResponseDTO delete(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			requisitoRepo.deleteById(Long.valueOf(id));
			return new ResponseDTO(HttpStatus.OK, new RequisitoDTO());
		}
	}

	public ResponseDTO findByMecanismoCompraID(String id) {

		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			List<RequisitoDTO> listDto = new ArrayList<>();
			requisitoRepo.findByMecanismoCompraId(Long.valueOf(id)).forEach(mc -> listDto.add(new RequisitoDTO(mc)));
			return new ResponseDTO(HttpStatus.OK, listDto);
		}
	}

}
