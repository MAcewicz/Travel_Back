package com.kodilla.travel.domain;

import com.kodilla.travel.converter.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"WEATHER\"")
public class Weather {

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;
    private int temperature;
    private int cloudiness;
    private int rainfall;

    public Weather(String city, LocalDate date, int temperature, int cloudiness, int rainfall) {
        this.city = city;
        this.date = date;
        this.temperature = temperature;
        this.cloudiness = cloudiness;
        this.rainfall = rainfall;
    }
}
