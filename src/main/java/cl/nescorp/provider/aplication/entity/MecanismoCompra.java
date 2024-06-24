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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="UNIDAD_id")
	private Unidad unidadMoneda;

//	@OneToMany( mappedBy="mecanismoCompra", fetch = FetchType.LAZY)
//	private List<DetalleRequisitoMecanismoCompra> detalleRequisitos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TIPO_MECANISMO_COMPRA_id")
	private TipoMecanismoCompra tipoMecanismoCompra;

}
