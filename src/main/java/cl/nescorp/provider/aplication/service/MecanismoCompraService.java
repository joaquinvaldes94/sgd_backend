package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.MecanismoCompraDTO;
import cl.nescorp.provider.aplication.dto.MecanismoCompraRequestDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.entity.ClasificacionCompra;
import cl.nescorp.provider.aplication.entity.MecanismoCompra;
import cl.nescorp.provider.aplication.entity.Moneda;
import cl.nescorp.provider.aplication.repository.ClasificacionCompraRepository;
import cl.nescorp.provider.aplication.repository.MecanismoCompraRepository;
import cl.nescorp.provider.aplication.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MecanismoCompraService {

	private final MecanismoCompraRepository mecanismoCompraRepo;
	private final ClasificacionCompraRepository clasificacionCompraRepo;

	public ResponseDTO findAll() {
		List<MecanismoCompraDTO> dtoList = new ArrayList<>();
		List<MecanismoCompra> listAll = mecanismoCompraRepo.findAll();
		listAll.forEach(mc -> {
			dtoList.add(new MecanismoCompraDTO(mc));
		});
		return new ResponseDTO(HttpStatus.OK, dtoList);
	}

	public ResponseDTO findById(String id) {

		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			MecanismoCompra mc = mecanismoCompraRepo.findById(Long.valueOf(id)).orElse(new MecanismoCompra());
			return new ResponseDTO(HttpStatus.OK, new MecanismoCompraDTO(mc));
		}
	}

	public ResponseDTO save(MecanismoCompraRequestDTO request) {
		if (null == request.getClasificacionCompraID()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			ClasificacionCompra cc = clasificacionCompraRepo.findById(Long.valueOf(request.getId())).orElse(null);
			if (null == cc) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
		MecanismoCompra mc = new MecanismoCompra();
		mc.setNombre(request.getNombre());
		mc.setMontoMinimo(Long.valueOf(request.getMontoMinimo()));
		mc.setMontoMaximo(Long.valueOf(request.getMontoMaximo()));
		mc.setComentario(request.getComentario());
		mc.setFechaCreacion(Utils.findDateTimeNow());
		mc.setMoneda(new Moneda(Long.valueOf(request.getMonedaID())));
		mc.setClasificacionCompra(new ClasificacionCompra(Long.valueOf(request.getClasificacionCompraID())));
		mc = mecanismoCompraRepo.save(mc);

		return new ResponseDTO(HttpStatus.OK, mc.getId());}}
	}

	public ResponseDTO update(MecanismoCompraRequestDTO request) {
		if (null == request.getId()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			MecanismoCompra mc = mecanismoCompraRepo.findById(Long.valueOf(request.getId())).orElse(null);
			if (null == mc) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
				mc.setNombre(request.getNombre());
				mc.setMontoMinimo(Long.valueOf(request.getMontoMinimo()));
				mc.setMontoMaximo(Long.valueOf(request.getMontoMaximo()));
				mc.setComentario(request.getComentario());
				mc.setMoneda(new Moneda(Long.valueOf(request.getMonedaID())));
				mc.setClasificacionCompra(new ClasificacionCompra(Long.valueOf(request.getClasificacionCompraID())));
				mc = mecanismoCompraRepo.save(mc);
				return new ResponseDTO(HttpStatus.OK, new MecanismoCompraDTO(mc));
			}
		}
	}

	public ResponseDTO delete(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			mecanismoCompraRepo.deleteById(Long.valueOf(id));
			return new ResponseDTO(HttpStatus.OK, new MecanismoCompraDTO());
		}
	}

	public ResponseDTO findByClasificacionCompraID(String id) {

		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			List<MecanismoCompraDTO> listDto = new ArrayList<>();
			mecanismoCompraRepo.findByClasificacionCompraId(Long.valueOf(id))
					.forEach(mc -> listDto.add(new MecanismoCompraDTO(mc)));
			return new ResponseDTO(HttpStatus.OK, listDto);
		}
	}

}
