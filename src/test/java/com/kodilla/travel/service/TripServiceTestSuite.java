package com.kodilla.travel.service;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.domain.Hotel;
import com.kodilla.travel.domain.Trip;
import com.kodilla.travel.domain.User;
import com.kodilla.travel.repository.TripRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTestSuite {

    @InjectMocks
    private TripService tripService;

    @Mock
    private TripRepository tripRepository;

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
    public void shouldFetchAllTrips() {
        //Given
        List<Trip> trips = new ArrayList<>();
        trips.add(getTrip());
        trips.add(getTrip());

        when(tripRepository.findAll()).thenReturn(trips);
        //When
        List<Trip> resultList = tripService.getAllTrips();
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void shouldFetchTripById() {
        //Given
        Trip trip = getTrip();

        when(tripRepository.findById(5L)).thenReturn(java.util.Optional.ofNullable(trip));
        //When
        Optional<Trip> result = tripService.getTripById(5L);
        //Then
        assertNotNull(result);
    }

    @Test
    public void shouldFetchTripsByUser() {
        //Given
        List<Trip> trips = new ArrayList<>();
        trips.add(getTrip());
        trips.add(getTrip());
        trips.add(getTrip());

        when(tripRepository.findAllByUserId(2L)).thenReturn(trips);
        //When
        List<Trip> resultList = tripService.getTripsByUser(2L);
        //Then
        assertEquals(resultList.size(), 3);
    }

    @Test
    public void shouldUpdateTrip() {
        //Given
        Trip trip = getTrip();
        Trip result = null;

        when(tripRepository.save(trip)).thenReturn(trip);
        //When
        result = tripService.saveTrip(trip);
        //Then
        assertNotNull(result);
    }
}
