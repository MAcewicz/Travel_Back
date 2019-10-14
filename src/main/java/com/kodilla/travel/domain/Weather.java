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
@Table(name = "\"WEATHER\"")
public class Weather {

    @Id
    @GeneratedValue
    private Long id;
    private String cityName;
    private int temperature;
    private String cloudiness;
    private String rainfall;
}
