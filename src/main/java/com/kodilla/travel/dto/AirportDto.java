package com.kodilla.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AirportDto {

    private Long id;
    private String name;
    private String iata;
    private String city;
    private String country;
    private String countryCode;
}
