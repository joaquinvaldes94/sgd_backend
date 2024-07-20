package cl.nescorp.provider.aplication.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public enum EstadoSolicitudEnum {
	INGRESADA("dsadsa"),
	FIRMADA(""),
	APROBADA(""),
	EJECUTADA(""),
	RECHAZADA(""),
	CANCELADA("");
	
@Getter
private final String descripcion;
}
