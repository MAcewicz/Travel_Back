package com.kodilla.travel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

    private Long id;
    private String city;
    private LocalDate date;
    private int temperature;
    private int cloudiness;
    private int rainfall;
}
