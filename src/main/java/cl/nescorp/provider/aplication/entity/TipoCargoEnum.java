package cl.nescorp.provider.aplication.entity;

public enum TipoCargoEnum {
	SegunDistribicion(Long.valueOf(0)),
	Jefatura(Long.valueOf(1)),
	Administrativo(Long.valueOf(2)),
	Subrogante(Long.valueOf(3)),
	Tecnico(Long.valueOf(4));
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TipoCargoEnum(Long id) {
		this.id = id;
	}
	
	
	

}
