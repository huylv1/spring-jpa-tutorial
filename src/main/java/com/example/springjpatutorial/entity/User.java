package com.example.springjpatutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "User")
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;
}
