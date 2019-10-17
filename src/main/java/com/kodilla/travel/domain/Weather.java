package com.kodilla.travel.domain;

import com.kodilla.travel.LocalDateConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;
    private int temperature;
    private String cloudiness;
    private String rainfall;
}
