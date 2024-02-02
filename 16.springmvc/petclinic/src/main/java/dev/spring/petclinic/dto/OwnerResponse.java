package dev.spring.petclinic.dto;

/*
    Owner에 대한 응답(Response) 데이터 전달용 DTO 클래스

 */

import dev.spring.petclinic.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
public class OwnerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    private List<PetResponse> pets;

    // 정적 팩토리 메서드
    public static OwnerResponse fromWithPet(Owner owner) {
        // Owner 엔티티에 담긴 개별 값들을 추출
        final Long id = owner.getId();
        final String firstName = owner.getFirstName();
        final String lastName = owner.getLastName();
        final String address = owner.getAddress();
        final String city = owner.getCity();
        final String telephone = owner.getTelephone();
        final List<PetResponse> pets = owner.getPets().stream()
                .map(PetResponse::from)
                .collect(Collectors.toList());
        return new OwnerResponse(id, firstName, lastName, address, city, telephone, pets);
    }

    public static OwnerResponse from(Owner owner) {
        final Long id = owner.getId();
        final String firstName = owner.getFirstName();
        final String lastName = owner.getLastName();
        final String address = owner.getAddress();
        final String city = owner.getCity();
        final String telephone = owner.getTelephone();

        return new OwnerResponse(id, firstName, lastName, address, city, telephone);
    }

    public OwnerResponse(Long id, String firstName, String lastName, String address, String city, String telephone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
}
