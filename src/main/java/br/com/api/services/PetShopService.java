package br.com.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import br.com.api.models.PetShop;
import br.com.api.repositories.PetShopRepository;

@Service
public class PetShopService {

    @Autowired
    PetShopRepository petShopRepository;

    public PetShop create(PetShop petShop) throws Exception {
        try {
            PetShop petsh = new PetShop(petShop.getName(), petShop.getDescription());
            PetShop createdPetShop = this.petShopRepository.saveAndFlush(petsh);

            return createdPetShop;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public PetShop findById(Long id) throws Exception {
        try {
            Optional<PetShop> searchPetShop = this.petShopRepository.findById(id);

            if (searchPetShop.isPresent()) {
                return searchPetShop.get();
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public PetShop saveAndFlush(PetShop petShop) {
        return this.petShopRepository.saveAndFlush(petShop);
    }
}
