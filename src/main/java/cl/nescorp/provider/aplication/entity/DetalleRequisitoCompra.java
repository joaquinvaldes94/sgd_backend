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
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DETALLE_REQUISITO_COMPRA")
public class DetalleRequisitoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MECANISMO_COMPRA_id")
	private MecanismoCompra mecanismoCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="REQUISITO_COMPRA_id")
	private RequisitoCompra requisitoCompra;
	
	
}
