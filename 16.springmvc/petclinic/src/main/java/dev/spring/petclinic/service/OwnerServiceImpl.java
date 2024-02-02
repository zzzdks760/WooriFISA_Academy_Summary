package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    @Override
    public Owner update(Long id, Owner owner) {
        Optional<Owner> findOwner = ownerRepository.findById(id);

        if (findOwner.isPresent()) {
            Owner exOwner = findOwner.get();
            findOwner.get().updateOwner(
                    owner.getFirstName() != null ? owner.getFirstName() : exOwner.getFirstName(),
                    owner.getLastName() != null ? owner.getLastName() : exOwner.getLastName(),
                    owner.getAddress() != null ? owner.getAddress() : exOwner.getAddress(),
                    owner.getCity() != null ? owner.getCity() : exOwner.getCity(),
                    owner.getTelephone() != null ? owner.getTelephone() : exOwner.getTelephone()
            );
            return exOwner;
        }

        return null;
    }

    @Override
    public List<Owner> findAll() {
        List<Owner> owners = new ArrayList<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public List<Owner> findLastNameOrFirstName(String name) {
        List<Owner> owners = new ArrayList<>();
        ownerRepository.findLastNameOrFirstName(name).forEach(owners::add);
        return owners;
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }
}
