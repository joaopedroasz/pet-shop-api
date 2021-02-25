package br.com.api.repositories;

import br.com.api.models.Animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByName(String name);
}
