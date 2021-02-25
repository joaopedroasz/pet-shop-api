package br.com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.models.PetShop;
import br.com.api.models.Animal;
import br.com.api.services.AnimalPetshopService;
import br.com.api.services.PetShopService;
import br.com.api.utils.HttpResponse;

@RestController
@RequestMapping("/petshops")
public class PetShopController {

    @Autowired
    PetShopService petShopService;

    @Autowired
    AnimalPetshopService animalPetshopService;

    @PostMapping("/create")
    public ResponseEntity<PetShop> createPetShop(@RequestBody PetShop petShop) throws Exception {
        PetShop createdPetShop = this.petShopService.create(petShop);

        return new HttpResponse<PetShop>().ok(petShop);
    }

    @GetMapping("/animals/{petShopId}")
    public ResponseEntity<List<Animal>> animalsPerPetShop(@PathVariable("petShopId") Long petShopId) throws Exception {
        List<Animal> animalsPerPetShop = this.animalPetshopService.filterAnimalsPerPetShop(petShopId);

        return new HttpResponse<List<Animal>>().ok(animalsPerPetShop);
    }

}
