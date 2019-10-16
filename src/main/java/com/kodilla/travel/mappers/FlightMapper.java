package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.dto.FlightDto;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {

    public Flight mapToFlight(FlightDto flightDto) {
        return new Flight(flightDto.getId(),
                flightDto.getAirline(),
                flightDto.getAirport(),
                flightDto.getDestination(),
                flightDto.getDeparture(),
                flightDto.getArrival(),
                flightDto.getPrice());
    }

    public FlightDto mapToFlightDto(Flight flight) {
        return new FlightDto(flight.getId(),
                flight.getAirline(),
                flight.getAirport(),
                flight.getDestination(),
                flight.getDeparture(),
                flight.getArrival(),
                flight.getPrice());
    }

    public List<FlightDto> mapToFlightDtoList(List<Flight> flights) {
        return flights.stream()
                .map(f -> new FlightDto(
                        f.getId(),
                        f.getAirline(),
                        f.getAirport(),
                        f.getDestination(),
                        f.getDeparture(),
                        f.getArrival(),
                        f.getPrice()))
                .collect(Collectors.toList());
    }
}
