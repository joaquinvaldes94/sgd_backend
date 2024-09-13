package cl.nescorp.provider.aplication.dto;

import cl.nescorp.provider.aplication.entity.Moneda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonedaDTO {
	

	private Long id;
	private String codigo;
	private Integer decimales;
	private String nombre;
	private String descripcion;
	
	public MonedaDTO(Moneda moneda) {
		super();
		this.id = moneda.getId();
		this.codigo = moneda.getCodigo();
		this.decimales = moneda.getDecimales();
		this.nombre = moneda.getNombre();
		this.descripcion = moneda.getDescripcion();
	}
	
	
	

}
