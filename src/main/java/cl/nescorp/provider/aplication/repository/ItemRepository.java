package cl.nescorp.provider.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.nescorp.provider.aplication.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {


}
