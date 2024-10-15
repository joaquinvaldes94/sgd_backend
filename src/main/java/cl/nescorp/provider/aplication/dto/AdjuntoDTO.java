package cl.nescorp.provider.aplication.dto;

import cl.nescorp.provider.aplication.entity.Requisito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdjuntoDTO {

	private String cantidad;
	private String idUnidad;
	private String precioUnitario;
	private String descripcion;
	private String idClasificacionPresupuestaria;
	
	public AdjuntoDTO(Requisito req) {
		super();
	}
	
	

}
