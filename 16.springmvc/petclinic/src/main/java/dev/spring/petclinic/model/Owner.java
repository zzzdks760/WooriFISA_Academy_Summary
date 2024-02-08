package dev.spring.petclinic.model;

import dev.spring.petclinic.dto.OwnerRequest;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "owners")
public class Owner extends BaseEntity {

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, List<Pet> pets) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updateOwner(String firstName, String lastName, String address, String city, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

}
