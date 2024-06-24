package cl.nescorp.provider.aplication.entity;

import java.util.List;



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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TIPO_MECANISMO_COMPRA")
public class TipoMecanismoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;


	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@JsonIgnore
	@OneToMany( mappedBy="tipoMecanismoCompra", fetch = FetchType.LAZY)
	private List<MecanismoCompra> mecanismosDeCompra;

}
