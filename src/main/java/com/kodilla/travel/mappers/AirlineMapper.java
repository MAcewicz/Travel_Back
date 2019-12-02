package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.Airline;
import com.kodilla.travel.dto.AirlineDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirlineMapper {

    public Airline mapToAirline(AirlineDto airlineDto) {
        return new Airline(airlineDto.getId(), airlineDto.getName(), airlineDto.getIataCode());
    }

    public AirlineDto mapToAirlineDto(Airline airline) {
        return new AirlineDto(airline.getId(), airline.getName(), airline.getIataCode());
    }

    public List<AirlineDto> mapToAirlineDtoList(List<Airline> airlines) {
        return airlines.stream()
                .map(airline -> new AirlineDto(airline.getId(), airline.getName(), airline.getIataCode()))
                .collect(Collectors.toList());
    }
}
