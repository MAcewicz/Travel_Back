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
@Entity
@Table(name = "\"AIRPORTS\"")
@Getter
public class Airport {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String iata;
    private String city;
    private String country;
    private String countryCode;
}
