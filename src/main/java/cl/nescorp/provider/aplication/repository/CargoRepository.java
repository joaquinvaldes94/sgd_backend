package cl.nescorp.provider.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {


}
