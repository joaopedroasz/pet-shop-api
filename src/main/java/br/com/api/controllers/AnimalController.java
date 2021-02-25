package br.com.api.controllers;

import br.com.api.models.Animal;
import br.com.api.services.AnimalTagService;
import br.com.api.utils.HttpResponse;
import br.com.api.services.AnimalPetshopService;
import br.com.api.services.AnimalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @Autowired
    AnimalTagService animalTagService;

    @Autowired
    AnimalPetshopService animalPetshopService;

    @PostMapping("/create")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) throws Exception {
        Animal createdAnimal = animalTagService.validateAndCreateAnimal(animal);

        return new HttpResponse<Animal>().ok(createdAnimal);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Animal> findById(@PathVariable("id") Long id) throws Exception {
        Animal searchAnimal = animalService.findById(id);

        if (searchAnimal != null) {
            return new HttpResponse<Animal>().ok(searchAnimal);
        } else {
            return new HttpResponse<Animal>().error();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Animal>> findByName(@RequestParam("name") String name) throws Exception {
        List<Animal> animalsByName = animalService.findByName(name);

        if (animalsByName == null) {
            return new HttpResponse<List<Animal>>().error();
        } else {
            return new HttpResponse<List<Animal>>().ok(animalsByName);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<Animal>> findAll() throws Exception {
        List<Animal> animals = animalService.getAll();

        if (animals == null) {
            return new HttpResponse<>().error();
        } else {
            return new HttpResponse<List<Animal>>().ok(animals);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Animal> deleteById(@PathVariable("id") Long id) throws Exception {
        Animal searchAnimal = animalService.findById(id);

        if (searchAnimal != null) {
            animalService.deleteById(id);
            return new HttpResponse<Animal>().ok(searchAnimal);
        } else {
            return new HttpResponse<>().error();
        }
    }

    @PutMapping("/baths/{id}")
    public ResponseEntity<Animal> addNBathsToAnimal(@PathVariable("id") Long id,
            @RequestParam("numberOfBaths") Integer numberOfBaths) throws Exception {
        Animal animal = animalService.validadeAndUpdateNumberOfBaths(id, numberOfBaths);

        return new HttpResponse<Animal>().ok(animal);
    }

    @PutMapping("/petshop/{petShopId}")
    public ResponseEntity<Animal> addAnimalToPetShop(@PathVariable("petShopId") Long petShopId,
            @RequestParam("animalId") Long animalId) throws Exception {
        Animal updatedAnimal = this.animalPetshopService.addPetShopToAnimal(animalId, petShopId);

        return new HttpResponse<Animal>().ok(updatedAnimal);
    }
}
