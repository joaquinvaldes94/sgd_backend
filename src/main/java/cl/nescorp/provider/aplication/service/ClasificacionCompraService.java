package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.ClasificacionCompraDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.entity.ClasificacionCompra;
import cl.nescorp.provider.aplication.repository.ClasificacionCompraRepository;
import cl.nescorp.provider.aplication.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClasificacionCompraService {
	
	private final ClasificacionCompraRepository clasificacionCompraRepository;
	
	public ResponseDTO findAll() {
		
		List<ClasificacionCompraDTO> dtoList= new ArrayList<>();
		List<ClasificacionCompra> listAll= clasificacionCompraRepository.findAll();
		
		listAll.forEach(mc->{
			dtoList.add(new ClasificacionCompraDTO(mc));
			
		});
		return new ResponseDTO(HttpStatus.OK, dtoList);
	}

	public ResponseDTO findById(String id) {
	
		return new ResponseDTO(HttpStatus.OK, new ClasificacionCompraDTO(clasificacionCompraRepository.findById(Long.valueOf(id)).orElse(null)));
	}

	public ResponseDTO save(ClasificacionCompraDTO request) {
		
		ClasificacionCompra cc = new ClasificacionCompra();
		cc.setNombre(request.getNombre());
		cc.setDescripcion(request.getDescripcion());
		cc.setMecanismosDeCompra(null);
		cc.setFechaCreacion(Utils.findDateTimeNow());
		cc = clasificacionCompraRepository.save(cc);
		
		 	return new ResponseDTO(HttpStatus.OK, cc.getId());
	}

	public ResponseDTO update(ClasificacionCompraDTO request) {
		if (null == request.getId()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			ClasificacionCompra cc = clasificacionCompraRepository.findById(request.getId()).orElse(null);
			if (null == cc) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
				cc.setId(request.getId());
				cc.setNombre(request.getNombre());
				cc.setDescripcion(request.getDescripcion());
				cc.setMecanismosDeCompra(cc.getMecanismosDeCompra());
				cc = clasificacionCompraRepository.save(cc);
				return new ResponseDTO(HttpStatus.OK, new ClasificacionCompraDTO(cc));
			}
		}
	}

	public ResponseDTO delete(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			clasificacionCompraRepository.deleteById(Long.valueOf(id));
			return new ResponseDTO(HttpStatus.OK, new ClasificacionCompraDTO());
		}
		
	}
}
