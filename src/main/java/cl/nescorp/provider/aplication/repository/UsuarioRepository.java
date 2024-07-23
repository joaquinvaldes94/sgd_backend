package cl.nescorp.provider.aplication.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.nescorp.provider.aplication.entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  Optional<Usuario> findByFuncionarioDni(Integer dni);
  
  Optional<Usuario> findByFuncionarioDniAndFuncionarioCorreo(Integer dni, String correo);

}
