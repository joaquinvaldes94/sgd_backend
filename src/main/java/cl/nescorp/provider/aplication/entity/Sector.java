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
@Table(name="SECTOR")
public class Sector {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre",nullable = false)
	private String nombre;
	
	@JsonIgnore
	@Column(name="descripcion",nullable = true)
	private String descripcion;
	
	@JsonIgnore
	@OneToMany( mappedBy="sector", fetch = FetchType.LAZY)
	private List<Dependencia> unidades;
	
}
