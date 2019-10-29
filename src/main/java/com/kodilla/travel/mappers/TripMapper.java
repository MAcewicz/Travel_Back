package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.Trip;
import com.kodilla.travel.dto.TripDto;
import com.kodilla.travel.exception.FlightNotFoundException;
import com.kodilla.travel.exception.HotelNotFoundException;
import com.kodilla.travel.exception.UserNotFoundException;
import com.kodilla.travel.service.FlightService;
import com.kodilla.travel.service.HotelService;
import com.kodilla.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TripMapper {

    @Autowired
    private UserService userService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private HotelService hotelService;

    public List<TripDto> mapToTripDtoList(List<Trip> trips) {
        return trips.stream()
                .map(trip -> new TripDto.TripDtoBuilder()
                                        .id(trip.getId())
                                        .userId(trip.getUser().getId())
                                        .firstFlight(trip.getFirstFlight().getId())
                                        .returnFlight(trip.getReturnFlight().getId())
                                        .hotel(trip.getHotel().getId())
                                        .build())
                .collect(Collectors.toList());
    }

    public TripDto mapToTripDto(Trip trip) {
        return new TripDto.TripDtoBuilder()
                .id(trip.getId())
                .userId(trip.getUser().getId())
                .firstFlight(trip.getFirstFlight().getId())
                .returnFlight(trip.getReturnFlight().getId())
                .hotel(trip.getHotel().getId())
                .build();
    }

    public Trip mapToTrip(TripDto tripDto) throws UserNotFoundException, FlightNotFoundException, HotelNotFoundException {
        return new Trip.TripBuilder()
                .id(tripDto.getId())
                .user(userService.getUserById(tripDto.getUserId()).orElseThrow(UserNotFoundException::new))
                .firstFlight(flightService.getFlightById(tripDto.getFirstFlightId()).orElseThrow(FlightNotFoundException::new))
                .returnFlight(flightService.getFlightById(tripDto.getReturnFlightId()).orElseThrow(FlightNotFoundException::new))
                .hotel(hotelService.getHotelById(tripDto.getHotelId()).orElseThrow(HotelNotFoundException::new))
                .build();
    }
}


















































