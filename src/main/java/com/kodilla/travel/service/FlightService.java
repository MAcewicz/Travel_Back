package com.kodilla.travel.service;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(long id) {
        return flightRepository.findById(id);
    }

    public List<Flight> getFlightByStart(String start) {
        return flightRepository.findAllByFrom(start);
    }

    public List<Flight> getFlightByDestination(String destination) {
        return flightRepository.findAllByTo(destination);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(long id) {
        flightRepository.deleteById(id);
    }
}
