package com.kodilla.travel.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kodilla.travel.converter.ForecastDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonDeserialize(using = ForecastDeserializer.class)
public class ForecastDto {

    private List<WeatherDto> weatherDtos;

}
