package edu.inteli.backend.repository;

import edu.inteli.backend.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DogRepository extends JpaRepository<Dog, Integer> {
}
