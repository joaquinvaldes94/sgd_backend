package cl.nescorp.provider.aplication.entity;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="UNIDAD_id")
	private Unidad unidadMoneda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TIPO_MECANISMO_COMPRA_id")
	private TipoMecanismoCompra tipoMecanismoCompra;
	
	@JsonIgnore
	@OneToMany( mappedBy="mecanismoCompra", fetch = FetchType.LAZY)
	private List<DetalleRequisitoCompra> detalleRequisitos;

}
