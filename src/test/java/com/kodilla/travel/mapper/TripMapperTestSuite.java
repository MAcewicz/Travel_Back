package com.kodilla.travel.mapper;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.domain.Hotel;
import com.kodilla.travel.domain.Trip;
import com.kodilla.travel.domain.User;
import com.kodilla.travel.dto.TripDto;
import com.kodilla.travel.exception.FlightNotFoundException;
import com.kodilla.travel.exception.HotelNotFoundException;
import com.kodilla.travel.exception.UserNotFoundException;
import com.kodilla.travel.mappers.TripMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripMapperTestSuite {

    @Autowired
    private TripMapper tripMapper;

    private Trip getTrip() {
        User user = new User(2L,
                "Jan",
                "Kowalski",
                "123456789000",
                "jan@test.pl",
                "123123123",
                "test");
        LocalDateTime departureLdt = LocalDateTime.of(2019, 10, 20, 12, 00);
        LocalDateTime arrivalLdt = LocalDateTime.of(2019, 10, 20, 15, 15);
        Timestamp departureTs = Timestamp.valueOf(departureLdt);
        Timestamp arrivalTs = Timestamp.valueOf(arrivalLdt);
        BigDecimal price = new BigDecimal(220.00);
        Flight flight = new Flight(3L, "PLL Test", "Warsaw", "London", departureTs, arrivalTs, price);
        BigDecimal pricePerNight = new BigDecimal(50.00);
        Timestamp checkIn = Timestamp.valueOf("2019-11-09 12:00:00");
        Timestamp checkOut = Timestamp.valueOf("2019-11-10 10:30:00");
        Hotel hotel = new Hotel(1L, "Test", "Barcelona", pricePerNight, checkIn, checkOut);
        return new Trip.TripBuilder()
                .id(5L)
                .user(user)
                .firstFlight(flight)
                .returnFlight(flight)
                .hotel(hotel)
                .build();
    }

    @Test
    public void testMapToTripDtoList() {
        //Given
        List<Trip> trips = new ArrayList<>();
        trips.add(getTrip());
        trips.add(getTrip());
        //When
        List<TripDto> resultList = tripMapper.mapToTripDtoList(trips);
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void testMapToTripDto() {
        //Given
        Trip trip = getTrip();
        //When
        TripDto result = tripMapper.mapToTripDto(trip);
        //Then
        assertEquals(result.getId(), trip.getId());
        assertEquals(result.getUserId(), trip.getUser().getId());
        assertEquals(result.getFirstFlightId(), trip.getFirstFlight().getId());
        assertEquals(result.getReturnFlightId(), trip.getReturnFlight().getId());
        assertEquals(result.getHotelId(), trip.getHotel().getId());
    }

    @Test
    public void testMapToTrip() throws UserNotFoundException, HotelNotFoundException, FlightNotFoundException {
        //Given
        //When
        //Then
    }
}
