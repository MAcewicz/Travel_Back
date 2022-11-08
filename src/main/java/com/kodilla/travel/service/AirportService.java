package com.kodilla.travel.service;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.exception.AirportNotFoundException;
import com.kodilla.travel.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public List<Airport> getAirportsByCountry(String country) {
        return airportRepository.findByCountry(country);
    }

    public List<Airport> getAirportsByCity(String city) {
        return airportRepository.findByCity(city);
    }

    public Airport getAirportById(Long id) {
        try {
            return airportRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new AirportNotFoundException();
        }

    }

    public Airport getAirportByIATA(String iata) {
        try {
            return airportRepository.findByIata(iata).get();
        } catch (NoSuchElementException e) {
            throw new AirportNotFoundException();
        }

    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public void deleteById(Long id) {
        airportRepository.deleteById(id);
    }
}
