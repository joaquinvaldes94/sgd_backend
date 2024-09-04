package cl.nescorp.provider.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.MecanismoCompra;
import java.util.List;


public interface MecanismoCompraRepository extends JpaRepository<MecanismoCompra, Long> {
	
	public List<MecanismoCompra> findByClasificacionCompraId(Long id);


}
