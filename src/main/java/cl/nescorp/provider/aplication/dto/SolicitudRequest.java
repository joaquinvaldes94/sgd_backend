package cl.nescorp.provider.aplication.dto;

import java.util.List;

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
	private Long idMecanismoDeCompra;
	private Long idMoneda;
	private String materia;
	private List<ItemRequestDTO> items;
	private List<AdjuntoDTO> adjuntos;
	private Boolean afectoIva;
	
}
