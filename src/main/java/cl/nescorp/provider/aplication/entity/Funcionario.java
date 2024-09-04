package cl.nescorp.provider.aplication.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cl.nescorp.provider.aplication.util.Utils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "dni", length = 9, nullable = false, unique = true)
	private Integer dni;

	@Column(name = "correo", nullable = false, unique = true)
	private String correo;

	
	@Column(name = "nombres", length = 80, nullable = false, unique = false)
	private String nombres;

	@Column(name = "apellidos",length = 90, nullable = false, unique = false)
	private String apellidos;

	@Column(name = "nacimiento")
	private LocalDate nacimiento;

	@Column(name = "estado")
	private Integer estado;

	@Column(name = "fechaCreacion", nullable = false)
	@CreatedDate
	private LocalDateTime fechaCreacion;
	
	@OneToOne(mappedBy="funcionario")
	private Usuario usuario;

	public Funcionario(String dni, String correo, String nombres, String apellidos) {
		super();
		this.dni = Integer.parseInt(dni);
		this.correo = correo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.nacimiento = null;
		this.estado = 1;
		this.fechaCreacion = Utils.findDateTimeNow();
	}
 
	@JsonIgnore
	@OneToMany( mappedBy="funcionario", fetch = FetchType.LAZY)
	private List<Cargo> cargos;
	


}
