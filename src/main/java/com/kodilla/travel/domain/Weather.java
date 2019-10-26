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
    private String cityName;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;
    private int temperature;
    private String cloudiness;
    private String rainfall;
}
