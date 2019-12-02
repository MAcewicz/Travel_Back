package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "\"AIRLINES\"")
public class Airline {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String iataCode;
}
