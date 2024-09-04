package cl.nescorp.provider.aplication.entity;

import lombok.Getter;

@Getter
public enum EstadoFuncionarioEnum {
	ACTIVO(1), BLOQUEADO(2);

	private int id;

	private EstadoFuncionarioEnum(int i) {
		this.id = i;
		// TODO Auto-generated constructor stub
	}

	public static String getNameByID(int i) {

		switch (i) {

		case 1:
			return ACTIVO.toString();

		case 2:
			return BLOQUEADO.toString();
		}
		return null;
	}

}
