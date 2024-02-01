package dev.spring.petclinic.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "types")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Type extends BaseEntity{
    private String name;

    @Builder
    public Type(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
