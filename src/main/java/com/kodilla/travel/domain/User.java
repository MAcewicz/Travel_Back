package com.kodilla.travel.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "\"USERS\"",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}
)
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String pesel;
    private String email;
    private String phoneNumber;
    private String password;
    @OneToMany(targetEntity = Trip.class,
                mappedBy = "user",
                fetch = FetchType.LAZY)
    private List<Trip> trips = new ArrayList<>();

    public User(Long id, String name, String surname, String pesel, String email, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
