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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INDICE_PRESUPUESTARIO")
public class IndicePresupuestario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "subtitulo", nullable = false)
	private String subtitulo;
	
	@Column(name = "item", nullable = false)
	private String item;
	
	@Column(name = "asignacion", nullable = false)
	private String asignacion;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@JsonIgnore
	@OneToMany( mappedBy="indicePresupuestario", fetch = FetchType.LAZY)
	private List<Item> items;

}
