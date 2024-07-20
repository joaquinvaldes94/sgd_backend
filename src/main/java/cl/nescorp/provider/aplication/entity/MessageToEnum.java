package cl.nescorp.provider.aplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageToEnum {
	
	BIENVENIDA_NUEVO_USUARIO(Long.valueOf(1)),
	CONTRASEÑA_REESTABLECIDA(Long.valueOf(2)),
	DATOS_INGRESADOS_INVALIDOS(Long.valueOf(3)),
	CONTACTE_A_SOPORTE(Long.valueOf(4));
	
	private Long id;

}
