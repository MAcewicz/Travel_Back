package com.kodilla.travel.service;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.exception.FlightNotFoundException;
import com.kodilla.travel.repository.FlightRepository;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTestSuite {

    @InjectMocks
    private FlightService flightService;

    @Mock
    private FlightRepository flightRepository;

    private Flight getFlight() {
        LocalDateTime departureLdt = LocalDateTime.of(2019, 10, 20, 12, 00);
        LocalDateTime arrivalLdt = LocalDateTime.of(2019, 10, 20, 15, 15);
        Timestamp departureTs = Timestamp.valueOf(departureLdt);
        Timestamp arrivalTs = Timestamp.valueOf(arrivalLdt);
        BigDecimal price = new BigDecimal(220.00);
        return new Flight(2L, "PLL Test", "Warsaw", "London", departureTs, arrivalTs, price);
    }

    @Test
    public void shouldSaveFlight() {
        //Given
        Flight flight = getFlight();
        when(flightRepository.save(flight)).thenReturn(flight);
        //When
        Flight resultFlight = flightService.saveFlight(flight);
        //Then
        assertEquals(resultFlight.getId(), flight.getId());
        assertEquals(resultFlight.getAirline(), flight.getAirline());
        assertEquals(resultFlight.getAirport(), flight.getAirport());
        assertEquals(resultFlight.getDestination(), flight.getDestination());
        assertEquals(resultFlight.getDeparture(), flight.getDeparture());
        assertEquals(resultFlight.getArrival(), flight.getArrival());
        assertEquals(resultFlight.getPrice(), flight.getPrice());
    }



    @Test
    public void shouldFetchAllFlights() {
        //Given
        List<Flight> flights = new ArrayList<>();
        flights.add(getFlight());
        flights.add(getFlight());

        when(flightRepository.findAll()).thenReturn(flights);
        //When
        int result = flightService.getFlights().size();

        //Then
        assertEquals(result, 2);
    }

    @Test
    public void shouldFetchGivenFlight() throws FlightNotFoundException {
        //Given
        Flight flight = getFlight();

        when(flightRepository.findById(2L)).thenReturn(Optional.of(flight));
        //When
        Optional<Flight> resultFlight = flightService.getFlightById(2L);
        //Then
        assertNotNull(resultFlight);
    }

    @Test
    public void shouldFetchFlightByAirport() {
        //Given
        Flight flight1 = getFlight();
        Flight flight2 = getFlight();
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);

        when(flightRepository.findAllByAirport("Warsaw")).thenReturn(flights);
        //When
        List<Flight> resultList = flightService.getFlightsByAirport("Warsaw");
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void shouldFetchFlightsByDestination() {
        //Given
        Flight flight1 = getFlight();
        Flight flight2 = getFlight();
        Flight flight3 = getFlight();
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        when(flightRepository.findAllByDestination("London")).thenReturn(flights);
        //When
        List<Flight> resultList = flightService.getFlightsByDestination("London");
        //Then
        assertEquals(resultList.size(), 3);
    }

    @Test
    public void shouldFetchFlightsByAirportAndPrice() {
        //Given
        Flight flight = getFlight();
        List<Flight> flights = new ArrayList<>();
        flights.add(flight);

        when(flightRepository.findAllByAirportAndPrice("Warsaw", new BigDecimal(220.00))).thenReturn((flights));
        //When
        List<Flight> resultList = flightService.getFlightsByAirportAndPrice("Warsaw", new BigDecimal(220.00));
        //Then
        assertEquals(resultList.size(), 1);
    }

    @Test
    public void shouldFetchFlightsByDestinationAndPrice() {
        //Given
        Flight flight = getFlight();
        List<Flight> flights = new ArrayList<>();
        flights.add(flight);

        when(flightRepository.findAllByDestinationAndPrice("London", new BigDecimal(220.00))).thenReturn((flights));
        //When
        List<Flight> resultList = flightService.getFlightsByDestinationAndPrice("London", new BigDecimal(220.00));
        //Then
        assertEquals(resultList.size(), 1);
    }
}
