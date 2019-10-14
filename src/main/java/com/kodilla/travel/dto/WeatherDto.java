package com.kodilla.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WeatherDto {

    private Long id;
    private String cityName;
    private int temperature;
    private String cloudiness;
    private String rainfall;
}
