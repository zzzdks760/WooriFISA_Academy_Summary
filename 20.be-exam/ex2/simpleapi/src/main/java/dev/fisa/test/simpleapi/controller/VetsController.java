package dev.fisa.test.simpleapi.controller;

import dev.fisa.test.simpleapi.model.Vets;
import dev.fisa.test.simpleapi.repository.VetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class VetsController {

    private final VetsRepository vetsRepository;

    @PostMapping("/vets")
    public ResponseEntity<Vets> create(@RequestBody Vets vets) {
        Vets save = vetsRepository.save(vets);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/vets/v2")
    public Vets create2(@RequestBody Vets vets) {
        return vetsRepository.save(vets);
    }

    @GetMapping("/vets")
    public Vets findFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return vetsRepository.findVetsByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/vets/{id}")
    public Vets find(@PathVariable Long id) {
        Optional<Vets> vets = vetsRepository.findById(id);
        return vets.get();
    }
}
