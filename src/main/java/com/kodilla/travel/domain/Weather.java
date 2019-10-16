package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
