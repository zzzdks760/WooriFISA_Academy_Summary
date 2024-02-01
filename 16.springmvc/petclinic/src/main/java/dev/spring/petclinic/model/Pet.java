package dev.spring.petclinic.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "pets")
public class Pet extends BaseEntity{

    private String name;

    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type petType;

    @Builder
    public Pet(Long id, Owner owner, String name, LocalDate birthDate, Type petType) {
        super(id);
        this.owner = owner;
        this.name = name;
        this.birthDate = birthDate;
        this.petType = petType;
    }

}

