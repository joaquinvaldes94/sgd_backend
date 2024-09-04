package cl.nescorp.provider.aplication.entity;

import java.time.LocalDateTime;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REQUISITO")
public class Requisito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	 
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "obligatorio", nullable = false)
	private Boolean obligatorio;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "extensiones", nullable = false)
	private String extensiones;
	
	@Column(name = "formatoBase", nullable = true)
	private String formatoBase;
	
	@Column(name = "fechaCreacion", nullable = false)
	@CreatedDate
	private LocalDateTime fechaCreacion;
	
	@JsonIgnore
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MECANISMO_COMPRA_id")
	private MecanismoCompra mecanismoCompra;
	
	
	
}
