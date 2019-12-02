package com.kodilla.travel.service;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public List<Airport> getAirportsByCountry(String country) {
        return airportRepository.findByCountry(country);
    }

    public List<Airport> getAirportsByCity(String city) {
        return airportRepository.findByCity(city);
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Optional<Airport> getAirportByName(String name) {
        return airportRepository.findByName(name);
    }

    public Optional<Airport> getAirportByIATA(String iata) {
        return airportRepository.findByIata(iata);
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public void deleteById(Long id) {
        airportRepository.deleteById(id);
    }
}
