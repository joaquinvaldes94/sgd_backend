package cl.nescorp.provider.aplication.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  Optional<Usuario> findByNick(String email);

}
