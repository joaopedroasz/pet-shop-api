package br.com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.models.Animal;
import br.com.api.models.PetShop;

@Service
public class AnimalPetshopService {

    @Autowired
    AnimalService animalService;

    @Autowired
    PetShopService petShopService;

    public Animal addPetShopToAnimal(Long animalId, Long petShopId) throws Exception {
        try {
            Animal searchAnimal = this.animalService.findById(animalId);
            PetShop searchPetShop = this.petShopService.findById(petShopId);

            if (searchAnimal == null || searchPetShop == null) {
                return null;
            }

            searchAnimal.addPetShop(searchPetShop);
            Animal updatedAnimal = this.animalService.saveAndFlush(searchAnimal);

            return updatedAnimal;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Animal> filterAnimalsPerPetShop(Long petShopId) throws Exception {
        try {
            return this.animalService.filterAnimalsPerPetShop(petShopId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
