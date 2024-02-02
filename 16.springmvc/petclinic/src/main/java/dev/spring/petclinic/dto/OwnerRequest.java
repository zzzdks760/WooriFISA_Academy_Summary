package dev.spring.petclinic.dto;

import dev.spring.petclinic.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

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
    private List<PetRequest> pets;

}
