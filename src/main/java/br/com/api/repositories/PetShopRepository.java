package br.com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.models.PetShop;

@Repository
public interface PetShopRepository extends JpaRepository<PetShop, Long> {

}
