package cl.nescorp.provider.aplication.dto;

import java.util.ArrayList;
import java.util.List;

import cl.nescorp.provider.aplication.entity.MecanismoCompra;
import cl.nescorp.provider.aplication.entity.Requisito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MecanismoCompraDTO {
	
	
	private String id;
	private String nombre;
	private String montoMinimo;
	private String montoMaximo;
	private MonedaDTO moneda;
	private List<RequisitoDTO> requisitos;

	public MecanismoCompraDTO(MecanismoCompra mc) {
		
		super();
		this.nombre = mc.getNombre();
		this.id = String.valueOf(mc.getId());
		this.montoMinimo = String.valueOf(mc.getMontoMinimo());
		this.montoMaximo = String.valueOf(mc.getMontoMaximo());
		this.moneda = mc.getMoneda()!=null ? new MonedaDTO(mc.getMoneda()): null;
		this.requisitos = null != mc.getDetalleRequisitos() ? this.mappingRequisitos(mc.getDetalleRequisitos()) : null;
	}


	private List<RequisitoDTO> mappingRequisitos(List<Requisito> detalleRequisitos) {
		
		List<RequisitoDTO> listDto = new ArrayList<>();
		detalleRequisitos.forEach(e -> listDto.add(new RequisitoDTO(e)));
		return listDto;
	}
	
	
	
	

}
