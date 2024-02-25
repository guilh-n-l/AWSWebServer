package edu.inteli.backend.service;

import edu.inteli.backend.dto.DogDTO;
import edu.inteli.backend.entities.Dog;
import edu.inteli.backend.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public DogDTO convertToDTO(Dog dog) {
        return new DogDTO(dog.getDog_id(), dog.getName(), dog.getBirthdate(), dog.getBreed(), dog.isAdopted());
    }

    public Dog convertToEntity(DogDTO dog) {
        return new Dog(dog.getDog_id(), dog.getName(), dog.getBirthdate(), dog.getBreed(), dog.isAdopted());
    }

    public List<DogDTO> getAllDogs() {
        return dogRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    public DogDTO getDogById(Integer dog_id) throws Exception {
        Optional<Dog> res = dogRepository.findById(dog_id);
        if (res.isPresent()) return convertToDTO(res.get());
        else throw new Exception(String.format("dog of id %d not found", dog_id));
    }

    public DogDTO createDog(DogDTO dog) {
        dogRepository.save(new Dog(dog.getDog_id(), dog.getName(), dog.getBirthdate(), dog.getBreed(), dog.isAdopted()));
        return dog;
    }

    public DogDTO updateDog(DogDTO dogNew, Integer id) throws Exception {
        DogDTO dogOld = getDogById(id);
        dogRepository.save(new Dog(
                dogNew.getDog_id(),
                dogNew.getName(),
                dogNew.getBirthdate(),
                dogNew.getBreed(),
                dogNew.isAdopted()
        ));
        return dogNew;
    }

    public void deleteDog(Integer id) throws Exception {
        System.out.println(id);
        DogDTO dog = getDogById(id);
        dogRepository.deleteById(id);
    }
}
