package br.com.api.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tags")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "animals" })
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "tag")
    private List<Animal> animals;

    @Column(name = "price")
    private Double price = 1.0;

    public Tag(String name) {
        this.name = name;
    }
}
