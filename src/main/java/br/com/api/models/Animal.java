package br.com.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    private Tag tag;

    @ManyToOne()
    private PetShop petshop;

    @Column(name = "total_baths")
    private Integer totalBaths = 0;

    public Animal(String name, Tag tag) {
        this.name = name;
        this.tag = tag;
    }

    public void addOneBath() {
        this.totalBaths += 1;
    }

    public void addNBaths(Integer numberOfBaths) {
        this.totalBaths += numberOfBaths;
    }

    public void addPetShop(PetShop petShop) {
        this.petshop = petShop;
    }
}
