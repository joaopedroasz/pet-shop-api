package br.com.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.models.Animal;
import br.com.api.models.Tag;

@Service
public class AnimalTagService {

    @Autowired
    AnimalService animalService;

    @Autowired
    TagService tagService;

    public Tag findTagByName(String name) {
        return tagService.findByName(name);
    }

    public Animal createAnimalAndTag(Animal animal, Tag tag) {
        Tag searchTag = tagService.findByName(tag.getName());

        if (searchTag != null) {
            return animalService.create(animal, tag);
        } else {
            Tag createdTag = tagService.create(tag);
            return animalService.create(animal, createdTag);
        }
    }

    public Animal validateAndCreateAnimal(Animal animal) throws Exception {
        try {
            Tag searchTag = this.findTagByName(animal.getTag().getName());

            if (searchTag != null) {
                if (searchTag.getName().equals(animal.getTag().getName())) {
                    Animal createdAnimal = this.createAnimalAndTag(animal, searchTag);
                    return createdAnimal;
                } else {
                    Animal createdAnimal = this.createAnimalAndTag(animal, animal.getTag());
                    return createdAnimal;
                }
            } else {
                Animal createdAnimal = this.createAnimalAndTag(animal, animal.getTag());
                return createdAnimal;
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Double getFullPrice(Long animalId) throws Exception {
        try {
            Animal animal = this.animalService.findById(animalId);

            if (animal == null) {
                return null;
            }

            Integer totalBaths = animal.getTotalBaths();
            Double tagPrice = animal.getTag().getPrice();

            Double fullPrice = tagPrice * totalBaths;

            return fullPrice;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
