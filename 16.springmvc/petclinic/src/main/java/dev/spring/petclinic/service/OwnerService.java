package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> findAllByLastNameLike(String lastName);
}
