package dev.fisa.test.simpleapi.repository;

import dev.fisa.test.simpleapi.model.Vets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetsRepository extends JpaRepository<Vets, Long> {
    Vets findVetsByFirstNameAndLastName(String firstName, String lastName);
}
