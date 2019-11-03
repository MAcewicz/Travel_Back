package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.AirportDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirportMapper {

    public List<AirportDto> mapToAirportDtoList(List<Airport> airports) {
        return airports.stream()
                .map(a -> new AirportDto(a.getId(), a.getName(), a.getIata(), a.getCity(), a.getCountry(), a.getCountryCode()))
                .collect(Collectors.toList());
    }

    public AirportDto mapToAirportDto(Airport airport) {
        return new AirportDto(airport.getId(),
                airport.getName(),
                airport.getIata(),
                airport.getCity(),
                airport.getCountry(),
                airport.getCountryCode());
    }

    public Airport mapToAirport(AirportDto airportDto) {
        return new Airport(airportDto.getId(),
                airportDto.getName(),
                airportDto.getIata(),
                airportDto.getCity(),
                airportDto.getCountry(),
                airportDto.getCountryCode());
    }
}
