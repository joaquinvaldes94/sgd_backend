package cl.nescorp.provider.aplication.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonSerialize
@NoArgsConstructor
@Entity
@Data
@Table(name = "CLASIFICACION_COMPRA")
public class ClasificacionCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;


	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "fechaCreacion", nullable = false)
	@CreatedDate
	private LocalDateTime fechaCreacion;
	
	@JsonIgnore
	@ToString.Exclude
	@OneToMany( mappedBy="clasificacionCompra", fetch = FetchType.EAGER)
	private List<MecanismoCompra> mecanismosDeCompra = new ArrayList<>();

	public ClasificacionCompra(Long id) {
		super();
		this.id = id;
	}
	
	

}
