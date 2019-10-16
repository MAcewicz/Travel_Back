package com.kodilla.travel.service;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.exception.FlightNotFoundException;
import com.kodilla.travel.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(long id) throws FlightNotFoundException {
        return flightRepository.findById(id);
    }

    public List<Flight> getFlightsByAirport(String airport) {
        return flightRepository.findAllByAirport(airport);
    }

    public List<Flight> getFlightsByDestination(String destination) {
        return flightRepository.findAllByDestination(destination);
    }

    public List<Flight> getFlightsByAirportAndPrice(String airport, BigDecimal price) {
        return flightRepository.findAllByAirportAndPrice(airport, price);
    }


    public List<Flight> getFlightsByDestinationAndPrice(String destination, BigDecimal price) {
        return flightRepository.findAllByDestinationAndPrice(destination, price);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(long id) {
        flightRepository.deleteById(id);
    }
}
