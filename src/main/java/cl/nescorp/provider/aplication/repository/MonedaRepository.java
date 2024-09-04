package cl.nescorp.provider.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.Moneda;

public interface MonedaRepository extends JpaRepository<Moneda, Long> {


}
