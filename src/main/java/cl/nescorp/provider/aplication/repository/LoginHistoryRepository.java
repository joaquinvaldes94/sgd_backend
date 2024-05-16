package cl.nescorp.provider.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.LoginHistory;

public interface LoginHistoryRepository  extends JpaRepository<LoginHistory, Integer> {
	
	Long countByUsuarioIdAndValidate(Integer usuarioId, Boolean validate); 
	
	Long countByUsuarioIdAndValidateAndIdIsGreaterThan(Integer usuarioId, Boolean validate, Integer id);
	
	LoginHistory findFirstByUsuarioIdAndValidateOrderByFechaCreacionDesc(Integer usuarioId, Boolean Validate);
	
	

}
