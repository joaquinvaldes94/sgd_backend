package cl.nescorp.provider.aplication.dto;

import java.util.ArrayList;
import java.util.List;

import cl.nescorp.provider.aplication.entity.ClasificacionCompra;
import cl.nescorp.provider.aplication.entity.MecanismoCompra;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionCompraDTO {

	private String nombre;
	private Long id;
	private String descripcion;
	private List<MecanismoCompraDTO> mecanismosCompra;

	public ClasificacionCompraDTO(ClasificacionCompra mc) {
		if (mc != null) {
			this.id = mc.getId();
			this.nombre = mc.getNombre();
			this.descripcion=mc.getDescripcion();
			this.mecanismosCompra = this.mappingMecanismosCompraDTO(mc.getMecanismosDeCompra());
		}
	}

	private List<MecanismoCompraDTO> mappingMecanismosCompraDTO(List<MecanismoCompra> listEntity) {

		List<MecanismoCompraDTO> listDto = new ArrayList<>();
		listEntity.forEach(e -> listDto.add(new MecanismoCompraDTO(e)));
		return listDto;

	}

}
