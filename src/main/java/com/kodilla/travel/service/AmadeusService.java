package com.kodilla.travel.service;

import com.amadeus.exceptions.ResponseException;
import com.kodilla.travel.amadeus.AmadeusClient;
import com.kodilla.travel.dto.FlightDto;
import com.kodilla.travel.exception.AirlineNotFoundException;
import com.kodilla.travel.exception.AirportNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AmadeusService {

    private final AmadeusClient amadeusClient;

    @Autowired
    public AmadeusService(AmadeusClient amadeusClient) {
        this.amadeusClient = amadeusClient;
    }

    public List<FlightDto> getCheapFlights(String origin, String destination, String departure) throws AirlineNotFoundException, AirportNotFoundException, ResponseException {

        return amadeusClient.getLowFare(origin, destination, LocalDate.parse(departure));
    }
}
