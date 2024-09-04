package cl.nescorp.provider.aplication.entity;

import java.util.Date;

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
@Table(name = "ADJUNTO")
public class Adjunto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombreArchivo", nullable = false)
	private String nombreArchivo;
	
	@Column(name = "extension", nullable = false)
	private String extension;
	
	@Column(name = "tamaño", nullable = false)
	private String tamaño;
	
	@Column(name="fecha_creacion",nullable = false)
	private Date fechaCreacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SOLICITUD_id")
	private Solicitud solicitud;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="REQUISITO_id")
	private Requisito requisito;
	

	
	
}
