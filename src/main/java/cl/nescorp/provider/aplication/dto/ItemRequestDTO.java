package cl.nescorp.provider.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDTO {
	private Long id;
	private Long cantidad;
	private Long idUnidad;
	private Long precioUnitario;
	private String detalle;
	private Long idClasificacionPresupuestaria;

	
	

}
