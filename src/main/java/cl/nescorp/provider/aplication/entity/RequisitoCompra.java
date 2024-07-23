package cl.nescorp.provider.aplication.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REQUISITO_COMPRA")
public class RequisitoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "extensiones", nullable = false)
	private String extensiones;
	
	@Column(name = "formatoBase", nullable = true)
	private String formatoBase;
	
	@JsonIgnore
	@OneToMany( mappedBy="requisitoCompra", fetch = FetchType.LAZY)
	private List<Adjunto> adjuntos;
	
	@JsonIgnore
	@OneToMany( mappedBy="requisitoCompra", fetch = FetchType.LAZY)
	private List<DetalleRequisitoCompra> detalleRequisitos;

}
