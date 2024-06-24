package cl.nescorp.provider.aplication.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

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
@Table(name="DEPENDENCIA")
public class Dependencia {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre",nullable = false)
	private String nombre;
	
	@Column(name="descripcion",nullable = true)
	private String descripcion;
	
	@Column(name="timbre",nullable = true)
	private String timbre;
	
	@Column(name="codigo",nullable = true)
	private String codigoUnidad;
	
	@Column(name="estado",nullable = false)
	private Integer estado;
	
	@Column(name = "fechaCreacion")
	@CreatedDate
    private LocalDateTime fechaCreacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TIPO_DEPENDENCIA_id")
	private TipoDependencia tipoDependencia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SECTOR_id")
	private Sector sector;
	
	@OneToMany( mappedBy="dependencia", fetch = FetchType.EAGER)
	private List<Cargo> cargos;
	
}
