package cl.nescorp.provider.aplication.entity;

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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ITEM")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cantidad", nullable = false)
	private Long cantidad;
	
	@Column(name = "detalle")
	private String detalle;
	
	@Column(name = "precioUnitario")
	private String precioUnitario;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="UNIDAD_id", nullable = false)
	private Unidad unidad;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="INDICE_PRESUPUESTARIO_id", nullable = false)
	private IndicePresupuestario indicePresupuestario;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="SOLICITUD_id", nullable = false)
	private Solicitud solicitud;
	
	
}
