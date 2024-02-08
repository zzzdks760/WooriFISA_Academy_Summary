package dev.spring.petclinic.dto;

import dev.spring.petclinic.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class OwnerRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

    public Owner toEntity() {
        return Owner.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .city(city)
                .telephone(telephone)
                .build();
    }
}
