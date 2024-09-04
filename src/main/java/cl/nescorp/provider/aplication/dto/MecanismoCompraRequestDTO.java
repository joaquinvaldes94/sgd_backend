package cl.nescorp.provider.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MecanismoCompraRequestDTO {
	
	private String nombre;
	private String id;
	private String montoMinimo;
	private String montoMaximo;
	private String comentario;
	private String clasificacionCompraID;
	private String monedaID;

	

}
