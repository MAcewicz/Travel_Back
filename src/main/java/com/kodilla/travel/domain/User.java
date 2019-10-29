package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    public User(String name, String surname, String pesel, String email, String phoneNumber, String password) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
