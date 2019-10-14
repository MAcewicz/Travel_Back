package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.dto.FlightDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {

    public Flight mapToFlight(FlightDto flightDto) {
        return new Flight(flightDto.getId(),
                flightDto.getAirline(),
                flightDto.getFrom(),
                flightDto.getTo(),
                flightDto.getDeparture(),
                flightDto.getArrival());
    }

    public FlightDto mapToFlightDto(Flight flight) {
        return new FlightDto(flight.getId(),
                flight.getAirline(),
                flight.getFrom(),
                flight.getTo(),
                flight.getDeparture(),
                flight.getArrival());
    }

    public List<FlightDto> mapToFlightDtoList(List<Flight> flights) {
        return flights.stream()
                .map(f -> new FlightDto(
                        f.getId(),
                        f.getAirline(),
                        f.getFrom(),
                        f.getTo(),
                        f.getDeparture(),
                        f.getArrival()))
                .collect(Collectors.toList());
    }
}
