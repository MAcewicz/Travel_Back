package com.kodilla.travel.controller;

import com.amadeus.exceptions.ResponseException;
import com.kodilla.travel.dto.FlightDto;
import com.kodilla.travel.exception.AirlineNotFoundException;
import com.kodilla.travel.exception.AirportNotFoundException;
import com.kodilla.travel.service.AmadeusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/travel/")
public class AmadeusController {

    @Autowired
    private AmadeusService amadeusService;

    @GetMapping("flights/{origin}/{destination}/{date}")
    public List<FlightDto> getFlights(@PathVariable String origin, @PathVariable String destination, @PathVariable String date) {
        List<FlightDto> flightDtoList = new ArrayList<>();
        try {
            flightDtoList = amadeusService.getCheapFlights(origin, destination, date);
        } catch (AirlineNotFoundException | AirportNotFoundException | ResponseException e) {
            e.printStackTrace();
        }
        return flightDtoList;
    }
}
