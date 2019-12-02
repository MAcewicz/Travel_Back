package com.kodilla.travel.service;

import com.kodilla.travel.domain.Airline;
import com.kodilla.travel.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public Optional<Airline> getAirlineByIata(String iata) {
        return airlineRepository.findByIataCode(iata);
    }

    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }
}
