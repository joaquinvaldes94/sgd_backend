package cl.nescorp.provider.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudRequest {
	
	private Long cargoCreador;
	private Long mecanismoDeCompra;

}
