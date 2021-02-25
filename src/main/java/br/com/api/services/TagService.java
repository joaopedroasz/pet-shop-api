package br.com.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.models.Tag;
import br.com.api.repositories.TagRepository;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public Tag create(Tag tag) {
        if (this.isExists(tag)) {
            return null;
        } else {
            return tagRepository.save(tag);
        }
    }

    public boolean isExists(Tag tag) {
        Tag searchTag = tagRepository.findByName(tag.getName());

        if (searchTag != null) {
            return true;
        } else {
            return false;
        }
    }

    public Tag findById(Long id) {
        Optional<Tag> searchTag = tagRepository.findById(id);

        if (searchTag.isPresent()) {
            return searchTag.get();
        } else {
            return null;
        }
    }

    public Tag findByName(String name) {
        Tag searchTag = tagRepository.findByName(name);

        if (searchTag != null) {
            return searchTag;
        } else {
            return null;
        }
    }

    public Tag updateTagPrice(Long id, Double price) throws Exception {
        try {
            Tag searchTag = this.findById(id);

            if (searchTag == null) {
                return null;
            }

            searchTag.setPrice(price);
            return this.tagRepository.saveAndFlush(searchTag);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
