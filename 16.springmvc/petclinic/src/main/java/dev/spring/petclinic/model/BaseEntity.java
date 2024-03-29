package dev.spring.petclinic.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
