package dev.syntax.security.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JoinColumn(name = "user")
    @ManyToOne
    private User user;
}