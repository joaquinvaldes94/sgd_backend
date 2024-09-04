package cl.nescorp.provider.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {

}
