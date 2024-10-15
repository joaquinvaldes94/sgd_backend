package cl.nescorp.provider.aplication.entity;

import lombok.Getter;

@Getter
public enum EstadoSolicitudEnum {
	INGRESADA(Long.valueOf(1)),
	PENDIENTE(Long.valueOf(2)),
	APROBADA(Long.valueOf(3)),
	RECHAZADA(Long.valueOf(4));
	
	
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}

	private EstadoSolicitudEnum(Long id) {
		this.id = id;
	}}