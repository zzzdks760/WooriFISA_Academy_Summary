package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }
}
