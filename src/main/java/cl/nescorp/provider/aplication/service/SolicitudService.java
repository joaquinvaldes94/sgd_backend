package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.dto.SolicitudDTO;
import cl.nescorp.provider.aplication.dto.SolicitudRequest;
import cl.nescorp.provider.aplication.entity.Cargo;
import cl.nescorp.provider.aplication.entity.EstadoSolicitud;
import cl.nescorp.provider.aplication.entity.EstadoSolicitudEnum;
import cl.nescorp.provider.aplication.entity.Item;
import cl.nescorp.provider.aplication.entity.MecanismoCompra;
import cl.nescorp.provider.aplication.entity.Moneda;
import cl.nescorp.provider.aplication.entity.Solicitud;
import cl.nescorp.provider.aplication.repository.SolicitudRepository;
import cl.nescorp.provider.aplication.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitudService {

	private final SolicitudRepository solRepository;

	public ResponseDTO create(SolicitudRequest request) {

		final Solicitud entity = new Solicitud();
		entity.setMecanismoCompra(new MecanismoCompra(request.getIdMecanismoDeCompra()));
		entity.setCargoCreador(new Cargo(request.getCargoCreador()));
		entity.setMoneda(new Moneda(request.getIdMoneda()));
		entity.setFechaCreacion(Utils.findDateTimeNow());
		entity.setMateria(request.getMateria());
		entity.setAfectoIva(request.getAfectoIva());
		if (null != request.getItems()) {
			List<Item> items = new ArrayList<>();
			request.getItems().stream().forEach(item -> {
				Item i = new Item(item);
				i.setSolicitud(entity);
				items.add(i);
			});
			entity.setItems(items);
		}
		entity.setTotalNeto(null != request.getItems()
				? request.getItems().stream().mapToLong(item -> item.getCantidad() * item.getPrecioUnitario()).sum()
				: 0);
		entity.setCodigo("codigo nose pa k");
		entity.setNumero(69);
		entity.setEstadoSolicitud(new EstadoSolicitud(EstadoSolicitudEnum.INGRESADA.getId()));
		entity.setValorDiaMoneda(new Long(0));
		Solicitud entitySave = solRepository.save(entity);

		return new ResponseDTO(HttpStatus.OK, entitySave.getId());
	}

	public ResponseDTO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseDTO findById(String id) {
		
		Solicitud solFound = solRepository.findById(Long.valueOf(id)).orElse(null);
		
		if(null!=solFound) {
			
			SolicitudDTO dto = new SolicitudDTO(solFound);
		
			return new ResponseDTO(HttpStatus.OK, dto);
			
		
			
		}else {
		// TODO Auto-generated method stub
		return new ResponseDTO(HttpStatus.OK, new  Object() );
	}
	
	}

}
