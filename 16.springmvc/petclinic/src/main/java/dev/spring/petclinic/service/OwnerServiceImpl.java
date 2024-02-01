package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        return ownerRepository.findAllByLastNameLike(lastName);
    }
}
