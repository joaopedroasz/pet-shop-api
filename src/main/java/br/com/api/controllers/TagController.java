package br.com.api.controllers;

import br.com.api.models.Animal;
import br.com.api.models.Tag;
import br.com.api.services.AnimalTagService;
import br.com.api.services.TagService;
import br.com.api.utils.HttpResponse;

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

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @Autowired
    AnimalTagService animalTagService;

    @PostMapping("/create")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) throws Exception {
        try {
            Tag createdTag = new Tag(tag.getName());
            Tag savedTag = tagService.create(createdTag);
            return new HttpResponse<Tag>().ok(savedTag);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Tag> searchTag(@PathVariable("id") Long id) {
        Tag searchTag = tagService.findById(id);

        return new HttpResponse<Tag>().ok(searchTag);
    }

    @GetMapping("/price/{animalId}")
    public ResponseEntity<Double> getFullPrice(@PathVariable("animalId") Long animalId) throws Exception {
        Double fullPrice = this.animalTagService.getFullPrice(animalId);

        return new HttpResponse<Double>().ok(fullPrice);
    }

    @PutMapping("/price/{tagId}")
    public ResponseEntity<Tag> setNewPrice(@PathVariable("tagId") Long tagId, @RequestParam("newPrice") Double newPrice)
            throws Exception {
        Tag updatedTag = this.tagService.updateTagPrice(tagId, newPrice);

        return new HttpResponse<Tag>().ok(updatedTag);
    }
}
