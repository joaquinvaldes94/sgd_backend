package cl.nescorp.provider.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {


}
