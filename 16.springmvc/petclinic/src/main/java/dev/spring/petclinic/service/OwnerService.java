package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    List<Owner> findAllByLastNameLike(String lastName);

    List<Owner> findLastNameOrFirstName(String name);

    Optional<Owner> findById(Long id);

    Owner save(Owner owner);

    Owner update(Long id, Owner owner);

    void delete(Owner owner);

    List<Owner> findAll();
}
