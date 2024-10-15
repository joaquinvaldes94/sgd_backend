package cl.nescorp.provider.aplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cl.nescorp.provider.aplication.entity.Requisito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequisitoDTO {
	
	private String nombre;
	private String idRequisito;
	@JsonIgnore
	private String id;
	private String cantidad;
	private String obligatorio;
	private String descripcion;
	private String extensiones;
	private String formatoBase;
	private String mecanismoCompraID;
	
	public RequisitoDTO(Requisito req) {
		super();
		this.nombre = req.getNombre();
		this.cantidad = String.valueOf(req.getCantidad());
		this.obligatorio = String.valueOf(req.getObligatorio());
		this.descripcion = req.getDescripcion();
		this.extensiones = req.getExtensiones();
		this.formatoBase = req.getFormatoBase();
		this.idRequisito = String.valueOf(req.getId());
	}
	
	

}
