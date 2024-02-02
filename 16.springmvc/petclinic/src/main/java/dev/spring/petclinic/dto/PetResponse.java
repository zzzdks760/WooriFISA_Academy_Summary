package dev.spring.petclinic.dto;

import dev.spring.petclinic.model.Pet;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PetResponse {
    private Long id;
    private String name;

    public static PetResponse from(Pet pet) {
        final Long id = pet.getId();
        final String name = pet.getName();

        return new PetResponse(id, name);
    }

    @Builder
    private PetResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
