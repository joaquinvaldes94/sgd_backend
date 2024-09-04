package cl.nescorp.provider.aplication.entity;

import lombok.Getter;


@Getter
public enum TipoCargoEnum {
	Jefatura(Long.valueOf(1)),
	Administrativo(Long.valueOf(2)),
	Subrogante(Long.valueOf(3)),
	Tecnico(Long.valueOf(4));
	
	private Long id;


	public void setId(Long id) {
		this.id = id;
	}

	private TipoCargoEnum(Long id) {
		this.id = id;
	}
	
	
	

}
