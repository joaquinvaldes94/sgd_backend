package cl.nescorp.provider.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.Requisito;
import java.util.List;


public interface RequisitoRepository extends JpaRepository<Requisito, Long> {
	
	public List<Requisito> findByMecanismoCompraId(Long id);


}
