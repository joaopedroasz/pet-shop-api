package br.com.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.models.Animal;
import br.com.api.models.Tag;
import br.com.api.repositories.AnimalRepository;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAll() throws Exception {
        try {
            List<Animal> animals = animalRepository.findAll();

            if (animals.isEmpty()) {
                return null;
            } else {
                return animals;
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Animal findById(Long id) throws Exception {
        try {
            Optional<Animal> searchAnimal = animalRepository.findById(id);

            if (searchAnimal.isPresent()) {
                return searchAnimal.get();
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void deleteById(Long id) throws Exception {
        try {
            animalRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Animal> findByName(String name) throws Exception {
        try {
            List<Animal> animalsByName = animalRepository.findByName(name);

            if (animalsByName.isEmpty()) {
                return null;
            } else {
                return animalsByName;
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Animal saveAndFlush(Animal animal) {
        return animalRepository.saveAndFlush(animal);
    }

    public Animal create(Animal animal, Tag tag) {
        return animalRepository.save(new Animal(animal.getName(), tag));
    }

    public Animal validadeAndUpdateNumberOfBaths(Long id, Integer numberOfBaths) throws Exception {
        try {
            Animal searchAnimal = this.findById(id);

            if (searchAnimal != null) {
                searchAnimal.addNBaths(numberOfBaths);
                Animal updatedAnimal = this.saveAndFlush(searchAnimal);
                return updatedAnimal;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Animal> filterAnimalsPerPetShop(Long petShopId) throws Exception {
        try {
            List<Animal> allAnimals = this.getAll();

            if (allAnimals == null) {
                return null;
            }

            List<Animal> animalsPerPetShop = new ArrayList<>();

            for (Animal animal : allAnimals) {
                if (animal.getPetshop() != null) {
                    if (animal.getPetshop().getId().equals(petShopId)) {
                        animalsPerPetShop.add(animal);
                    }
                }
            }

            return animalsPerPetShop;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
