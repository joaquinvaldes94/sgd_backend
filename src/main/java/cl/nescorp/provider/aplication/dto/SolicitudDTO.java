package cl.nescorp.provider.aplication.dto;

import java.util.ArrayList;
import java.util.List;

import cl.nescorp.provider.aplication.entity.Solicitud;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {
	
	public SolicitudDTO(Solicitud solFound) {
		this.id= solFound.getId();
		this.cod=solFound.getCodigo();
		this.fechaCreacion = solFound.getFechaCreacion().toString();
		this.numero = solFound.getNumero();
		this.totalNeto = solFound.getTotalNeto();
		this.valorDiaMoneda = solFound.getValorDiaMoneda();
		this.estado = solFound.getEstadoSolicitud().getNombre();
		this.cargoCreador = solFound.getCargoCreador().getNombre();
		this.moneda = new MonedaDTO(solFound.getMoneda());
		this.mecanismoDeCompra = new MecanismoCompraDTO(solFound.getMecanismoCompra());
		this.materia = solFound.getMateria();
		this.afectoIva = solFound.getAfectoIva().booleanValue();
		List<ItemDTO> dtoListItems = new ArrayList<>();
	solFound.getItems().stream().forEach(item-> dtoListItems.add(new ItemDTO(item)));
		this.items = dtoListItems;
	}
	private Long id;
	private String cod;
	private String fechaCreacion;
	private Integer numero;
	private Long totalNeto;
	private Long valorDiaMoneda;
	private String estado;
	private String cargoCreador;
	private MecanismoCompraDTO mecanismoDeCompra;
	private MonedaDTO moneda;
	private String materia;
	private List<ItemDTO> items;
	private List<AdjuntoDTO> adjuntos;
	private Boolean afectoIva;
	
}
