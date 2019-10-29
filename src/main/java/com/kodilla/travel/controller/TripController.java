package com.kodilla.travel.controller;

import com.kodilla.travel.domain.Trip;
import com.kodilla.travel.dto.TripDto;
import com.kodilla.travel.exception.FlightNotFoundException;
import com.kodilla.travel.exception.HotelNotFoundException;
import com.kodilla.travel.exception.TripNotFoundException;
import com.kodilla.travel.exception.UserNotFoundException;
import com.kodilla.travel.mappers.TripMapper;
import com.kodilla.travel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/v1/travel/")
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private TripMapper tripMapper;

    @GetMapping(value = "trips")
    public List<TripDto> getTrips() {
        return tripMapper.mapToTripDtoList(tripService.getAllTrips());
    }

    @GetMapping(value = "trip/{id}")
    public TripDto getTrip(@PathVariable Long id) throws TripNotFoundException {
        return tripMapper.mapToTripDto(tripService.getTripById(id).orElseThrow(TripNotFoundException::new));
    }

    @GetMapping(value = "trips/u/{userId}")
    public List<TripDto> getTripsByUser(@PathVariable Long userId) {
        return tripMapper.mapToTripDtoList(tripService.getTripsByUser(userId));
    }

    @PutMapping(value = "trips")
    public TripDto updateTrip(@RequestBody TripDto tripDto) throws UserNotFoundException, HotelNotFoundException, FlightNotFoundException {
        return tripMapper.mapToTripDto(tripService.saveTrip(tripMapper.mapToTrip(tripDto)));
    }

    @PostMapping(value = "trips")
    public void saveTrip(@RequestBody TripDto tripDto) throws UserNotFoundException, HotelNotFoundException, FlightNotFoundException {
        tripService.saveTrip(tripMapper.mapToTrip(tripDto));
    }

    @DeleteMapping(value = "trips/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.delete(id);
    }
}
