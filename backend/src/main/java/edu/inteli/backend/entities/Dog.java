package edu.inteli.backend.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long dog_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String breed;
    private boolean adopted;

    public Dog() {}

    public Dog(Long dog_id, String name, Date birthdate, String breed, boolean adopted) {
        this.dog_id = dog_id;
        this.name = name;
        this.birthdate = birthdate;
        this.breed = breed;
        this.adopted = adopted;
    }

    public void setDog_id(Long id) {
        this.dog_id = id;
    }

    public Long getDog_id() {
        return dog_id;
    }
}
