package cl.nescorp.provider.aplication.dto;

import cl.nescorp.provider.aplication.entity.Unidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {
	

	private Long id;
	private String nombre;
	private String descripcion;
	
	public CargoDTO(Unidad unidad) {
		super();
		this.id = unidad.getId();
		this.descripcion = unidad.getDescripcion();
		this.nombre = unidad.getNombre();
	}
	
	
	

}
