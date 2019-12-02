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
                .map(a -> new AirportDto(a.getId(),
                        a.getCity(),
                        a.getCountry(),
                        a.getCountryCode(),
                        a.getIata(),
                        a.getName()))
                .collect(Collectors.toList());
    }

    public AirportDto mapToAirportDto(Airport airport) {
        return new AirportDto(airport.getId(),
                airport.getCity(),
                airport.getCountry(),
                airport.getCountryCode(),
                airport.getIata(),
                airport.getName());
    }

    public Airport mapToAirport(AirportDto airportDto) {
        return new Airport(airportDto.getId(),
                airportDto.getCity(),
                airportDto.getCountry(),
                airportDto.getCountryCode(),
                airportDto.getIata(),
                airportDto.getName());
    }
}
