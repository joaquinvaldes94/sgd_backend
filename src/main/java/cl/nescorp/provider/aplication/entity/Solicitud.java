package cl.nescorp.provider.aplication.entity;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "SOLICITUD")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cod", nullable = false)
	private String codigo;
	
	@Column(name = "numero", nullable = false)
	private Integer numero;
	
	@Column(name = "fechaCreacion", nullable = false)
	private LocalDateTime fechaCreacion;
	
	@Column(name = "afectoIva", nullable = false)
	private Boolean afectoIva;
	 
	@Column(name = "materia", nullable = false)
	private String materia;
	
	@Column(name = "totalNeto", nullable = false)
	private Long totalNeto;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="MECANISMO_COMPRA_id", nullable = false)
	private MecanismoCompra mecanismoCompra;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="CARGO_id", nullable = false)
	private Cargo cargoCreador;
	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="ESTADO_SOLICITUD_id", nullable = false)
	private EstadoSolicitud estadoSolicitud;
	
	@JsonIgnore
	@OneToMany( mappedBy="solicitud", fetch = FetchType.LAZY)
	private List<Item> items;
	
	@JsonIgnore
	@OneToMany( mappedBy="solicitud", fetch = FetchType.LAZY)
	private List<Adjunto> adjuntos;
	

}
