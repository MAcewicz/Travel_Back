package com.kodilla.travel.service;

import com.kodilla.travel.domain.Airline;
import com.kodilla.travel.exception.AirlineNotFoundException;
import com.kodilla.travel.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public Airline getAirlineByIata(String iata) {
        try {
            return airlineRepository.findByIataCode(iata).get();
        } catch (NoSuchElementException e) {
            throw new AirlineNotFoundException();
        }

    }

    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }
}
