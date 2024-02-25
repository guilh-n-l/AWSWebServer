package edu.inteli.backend.dto;


import java.util.Date;

public class DogDTO {
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
    private Date birthdate;
    private String breed;
    private boolean adopted;

    public DogDTO() {
    }

    public DogDTO(Long dog_id, String name, Date birthdate, String breed, boolean adopted) {
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
