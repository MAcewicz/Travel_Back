package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.Trip;
import com.kodilla.travel.domain.User;
import com.kodilla.travel.dto.TripDto;
import com.kodilla.travel.exception.UserNotFoundException;
import com.kodilla.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TripMapper {

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private WeatherMapper weatherMapper;

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private UserService userService;

    public Trip mapToTrip(TripDto tripDto) throws UserNotFoundException {
        Trip trip = new Trip.TripBuilder()
                .id(tripDto.getId())
                .user(userService.getUserById(tripDto.getUserId()).orElseThrow(UserNotFoundException::new))
                .firstFlight(flightMapper.mapToFlight(tripDto.getFirstFlight()))
                .returnFlight(flightMapper.mapToFlight(tripDto.getReturnFlight()))
                .weather(weatherMapper.mapToWeather(tripDto.getWeather()))
                .hotel(hotelMapper.mapToHotel(tripDto.getHotel()))
                .build();
        return trip;
    }

    public TripDto mapToTripDto(Trip trip) {
        TripDto tripDto = new TripDto.TripDtoBuilder()
                .id(trip.getId())
                .userId(trip.getUser().getId())
                .firstFlight(flightMapper.mapToFlightDto(trip.getFirstFlight()))
                .returnFlight(flightMapper.mapToFlightDto(trip.getReturnFlight()))
                .weather(weatherMapper.mapToWeatherDto(trip.getWeather()))
                .hotel(hotelMapper.mapToHotelDto(trip.getHotel()))
                .build();
         return tripDto;
    }

    public List<TripDto> mapToTripDtoList(List<Trip> trips) {
        return trips.stream()
                .map(trip -> new TripDto.TripDtoBuilder()
                        .id(trip.getId())
                        .userId(trip.getUser().getId())
                        .firstFlight(flightMapper.mapToFlightDto(trip.getFirstFlight()))
                        .returnFlight(flightMapper.mapToFlightDto(trip.getReturnFlight()))
                        .weather(weatherMapper.mapToWeatherDto(trip.getWeather()))
                        .hotel(hotelMapper.mapToHotelDto(trip.getHotel()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<Trip> mapToTripList(List<TripDto> tripDtos) throws UserNotFoundException {
        return tripDtos.stream()
                .map(tripDto -> {
                    try {
                        return new Trip.TripBuilder()
                                .id(tripDto.getId())
                                .user(userService.getUserById(tripDto.getUserId()).orElseThrow(UserNotFoundException::new))
                                .firstFlight(flightMapper.mapToFlight(tripDto.getFirstFlight()))
                                .returnFlight(flightMapper.mapToFlight(tripDto.getReturnFlight()))
                                .weather(weatherMapper.mapToWeather(tripDto.getWeather()))
                                .hotel(hotelMapper.mapToHotel(tripDto.getHotel()))
                                .build();
                    } catch (UserNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}


















































