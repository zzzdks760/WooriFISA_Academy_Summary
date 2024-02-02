package dev.spring.petclinic.repository;

import dev.spring.petclinic.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/*
    CrudRepository - CRUD 위주의 기능을 제공하는 인터페이스
    CrudRepository<Entity Type, Id>

    JpaRepository - CRUD + 페이징 기능을 제공하는 인터페이스
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    List<Owner> findAllByLastNameLike(String lastName);

    @Query("select o from Owner o where o.firstName = :name or o.lastName = :name")
    List<Owner> findLastNameOrFirstName(String name);

}
