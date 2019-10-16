package com.kodilla.travel.controller;

import com.kodilla.travel.dto.FlightDto;
import com.kodilla.travel.exception.FlightNotFoundException;
import com.kodilla.travel.mappers.FlightMapper;
import com.kodilla.travel.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/travel/")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    FlightMapper flightMapper;

    @GetMapping(value = "flights")
    public List<FlightDto> getFlights() {
        return flightMapper.mapToFlightDtoList(flightService.getFlights());
    }

    @GetMapping(value = "flights/{id}")
    public FlightDto getFlight(@PathVariable Long id) throws FlightNotFoundException {
        return flightMapper.mapToFlightDto(flightService.getFlightById(id).orElseThrow(FlightNotFoundException::new));
    }

    @GetMapping(value = "flights/{airport}")
    public List<FlightDto> getFlightByAirport(@PathVariable String airport) {
        return flightMapper.mapToFlightDtoList(flightService.getFlightsByAirport(airport));
    }

    @GetMapping(value = "flight/{destination}")
    public List<FlightDto> getFlightsByDestination(@PathVariable String destination) {
        return flightMapper.mapToFlightDtoList(flightService.getFlightsByDestination(destination));
    }

    @GetMapping(value = "flight/{airport}/{prive}")
    public List<FlightDto> getFlightsByAirportAndPrice(@PathVariable String airport, @PathVariable BigDecimal price) {
        return flightMapper.mapToFlightDtoList(flightService.getFlightsByAirportAndPrice(airport, price));
    }

    @GetMapping(value = "flight/{destination}/{price}")
    public List<FlightDto> getFlightsByDestinationAndPrice(@PathVariable String destination, @PathVariable BigDecimal price) {
        return flightMapper.mapToFlightDtoList(flightService.getFlightsByDestinationAndPrice(destination, price));
    }

    @PutMapping(value = "flights")
    public FlightDto updateFlight(@RequestBody FlightDto flightDto) {
        return flightMapper.mapToFlightDto(flightService.saveFlight(flightMapper.mapToFlight(flightDto)));
    }

    @PostMapping(value = "flights")
    public void addFlight(@RequestBody FlightDto flightDto) {
        flightService.saveFlight(flightMapper.mapToFlight(flightDto));
    }

    @DeleteMapping(value = "flight/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

}
