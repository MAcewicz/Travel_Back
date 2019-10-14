package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "\"USERS\"")
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
