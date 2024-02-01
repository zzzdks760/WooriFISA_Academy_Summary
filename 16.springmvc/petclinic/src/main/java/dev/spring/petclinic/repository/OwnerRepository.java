package dev.spring.petclinic.repository;

import dev.spring.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
    CrudRepository - CRUD 위주의 기능을 제공하는 인터페이스
    CrudRepository<Entity Type, Id>

    JpaRepository - CRUD + 페이징 기능을 제공하는 인터페이스
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    List<Owner> findAllByLastNameLike(String lastName);
}
