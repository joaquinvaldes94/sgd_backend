package cl.nescorp.provider.aplication.dto;

import cl.nescorp.provider.aplication.entity.Item;
import cl.nescorp.provider.aplication.entity.Requisito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	
	private Long id;
	private Long cantidad;
	private UnidadDTO unidad;
	private Long precioUnitario;
	private String detalle;
	private String clasificacionPresupuestaria;

	public ItemDTO(Item item) {
		
		this.id = item.getId();
		this.cantidad = item.getCantidad();
		this.detalle = item.getDetalle();
		

	}
	

}
