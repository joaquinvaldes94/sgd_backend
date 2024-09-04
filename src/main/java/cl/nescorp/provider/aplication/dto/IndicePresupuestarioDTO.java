package cl.nescorp.provider.aplication.dto;

import cl.nescorp.provider.aplication.entity.IndicePresupuestario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndicePresupuestarioDTO {

	private Long id;
	private String nombre;
	private String descripcion;
	private String asignacion;
	private String item;
	private String subtitulo;

	public IndicePresupuestarioDTO(IndicePresupuestario indice) {
		super();
		this.id = indice.getId();
		this.descripcion = indice.getDescripcion();
		this.nombre = indice.getNombre();
		this.asignacion = indice.getAsignacion();
		this.item = indice.getItem();
		this.subtitulo = indice.getSubtitulo();
	}

}
