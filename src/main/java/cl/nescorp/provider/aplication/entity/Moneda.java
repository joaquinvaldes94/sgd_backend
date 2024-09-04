package cl.nescorp.provider.aplication.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "MONEDA")
public class Moneda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "codigo", nullable = true)
	private String codigo;
	
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	
	@Column(name = "decimales", nullable = true)
	private Integer decimales;
	
	@Column(name = "fechaCreacion", nullable = false)
	@CreatedDate
	private LocalDateTime fechaCreacion;
	
	@JsonIgnore
	@ToString.Exclude
	@OneToMany(mappedBy="moneda", fetch = FetchType.LAZY , cascade = CascadeType.DETACH)
	private List<MecanismoCompra> mecanismosCompra;
	
	@JsonIgnore
	@ToString.Exclude
	@OneToMany( mappedBy="moneda", fetch = FetchType.LAZY)
	private List<Solicitud> solicitudes;

	public Moneda(Long id) {
		super();
		this.id = id;
	}
	
	
	
}
