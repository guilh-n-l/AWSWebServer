package edu.inteli.backend.controller;

import edu.inteli.backend.dto.DogDTO;
import edu.inteli.backend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping()
    public List<DogDTO> getAllDogs() {
        return dogService.getAllDogs();
    }

    @GetMapping("/id={dog_id}")
    public ResponseEntity<DogDTO> getDogById(@PathVariable Integer dog_id) throws Exception {
        DogDTO dog = dogService.getDogById(dog_id);
        return ResponseEntity.ok(dog);
    }

    @PostMapping()
    public ResponseEntity<DogDTO> createDog(@RequestBody DogDTO dog) {
        DogDTO createdDog = dogService.createDog(dog);
        return ResponseEntity.ok(createdDog);
    }

    @PutMapping("/id={dog_id}")
    public ResponseEntity<DogDTO> updateDog(@RequestBody DogDTO dog, @PathVariable Integer dog_id) throws Exception {
        DogDTO updatedDog = dogService.updateDog(dog, dog_id);
        return ResponseEntity.ok(updatedDog);
    }

    @DeleteMapping("/id={dog_id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Integer dog_id) throws Exception {
        dogService.deleteDog(dog_id);
        return ResponseEntity.noContent().build();
    }
}

