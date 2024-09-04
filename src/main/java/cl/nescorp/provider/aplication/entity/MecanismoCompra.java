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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "MECANISMO_COMPRA")
public class MecanismoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "monto_minimo", nullable = false)
	private Long montoMinimo;

	@Column(name = "monto_maximo", nullable = false)
	private Long montoMaximo;
	
	@Column(name = "comentario", nullable = false)
	private String comentario;
	
	@Column(name = "fechaCreacion", nullable = false)
	@CreatedDate
	private LocalDateTime fechaCreacion;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MONEDA_id" , nullable = false)
	private Moneda moneda;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CLASIFICACION_COMPRA_id" , nullable = false)
	private ClasificacionCompra clasificacionCompra;
	
	@JsonIgnore
	@ToString.Exclude
	@OneToMany( mappedBy="mecanismoCompra", fetch = FetchType.EAGER)
	private List<Requisito> detalleRequisitos;
	
	@JsonIgnore
	@ToString.Exclude
	@OneToMany( mappedBy="mecanismoCompra", fetch = FetchType.LAZY)
	private List<Solicitud> solicitudes;

	public MecanismoCompra(Long id) {
		super();
		this.id = id;
	}
	
	
	

}
