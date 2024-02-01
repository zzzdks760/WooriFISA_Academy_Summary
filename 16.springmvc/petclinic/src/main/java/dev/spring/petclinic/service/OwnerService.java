package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    List<Owner> findAllByLastNameLike(String lastName);

    Optional<Owner> findById(Long id);

    Owner save(Owner owner);

    Owner update(Owner owner);
}
