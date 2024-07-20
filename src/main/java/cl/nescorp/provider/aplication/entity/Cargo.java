package cl.nescorp.provider.aplication.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="CARGO")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre",nullable = false)
	private String nombre;
	
	@Column(name="descripcion",nullable = true)
	private String descripcion;
	
	@Column(name = "fechaCreacion", nullable = false)
    @CreatedDate
    private LocalDateTime fechaCreacion;
	
	@Column(name="fechaTermino",nullable = true)
	private LocalDateTime fechaTermino;
	
	@Column(name="titular",nullable = true)
	private Boolean titular;
	
	@Column(name="estado",nullable = false)
	private Integer estado;
	
	@Column(name="vigencia",nullable = false)
	private Boolean vigencia;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="DEPENDENCIA_id", nullable = false)
	private Dependencia dependencia;
	
	@ManyToOne(optional = false ,fetch = FetchType.EAGER)
	@JoinColumn(name="FUNCIONARIO_id", nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="TIPO_CARGO_id", nullable = false)
	private TipoCargo tipoCargo;
	
	@JsonIgnore
	@OneToMany( mappedBy="cargoCreador", fetch = FetchType.LAZY)
	private List<Solicitud> solicitudes;
	
}
	