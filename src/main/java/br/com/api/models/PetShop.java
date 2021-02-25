package br.com.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "petshops")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "animals" })
public class PetShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "petshop")
    private List<Animal> animals;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public PetShop(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
