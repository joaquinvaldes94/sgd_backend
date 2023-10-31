package cl.nescorp.provider.aplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.nescorp.provider.aplication.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	Optional<Token> findByToken(String token);
	
	  @Query(value = """
		      select t from Token t inner join Usuario u\s
		      on t.usuario.id = u.id\s
		      where u.id = :id and (t.expirado = false or t.revocado = false)\s
		      """)
		  List<Token> findAllValidTokenByUser(Integer id);

}
