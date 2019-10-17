package com.kodilla.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WeatherDto {

    private Long id;
    private String cityName;
    private LocalDate date;
    private int temperature;
    private String cloudiness;
    private String rainfall;
}
