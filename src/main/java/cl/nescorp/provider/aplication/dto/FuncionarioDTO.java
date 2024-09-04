package cl.nescorp.provider.aplication.dto;

import cl.nescorp.provider.aplication.entity.EstadoFuncionarioEnum;
import cl.nescorp.provider.aplication.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

	private String id;
	private String rut;
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private String estado;
	private String correo;
	
	public FuncionarioDTO(Funcionario fun) {
		super();
		this.id = String.valueOf(fun.getId());
		this.rut =  String.valueOf(fun.getDni());
		this.nombres = fun.getNombres();
		this.apellidos = fun.getApellidos();
		this.fechaNacimiento = String.valueOf (fun.getNacimiento());
		this.estado = fun.getEstado()!=null ? EstadoFuncionarioEnum.getNameByID(fun.getEstado()): null;
		this.correo = fun.getCorreo();
	}
	
	
	
}
