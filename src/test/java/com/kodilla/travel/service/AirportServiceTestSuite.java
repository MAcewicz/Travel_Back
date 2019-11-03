package com.kodilla.travel.service;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.repository.AirportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AirportServiceTestSuite {

    @InjectMocks
    private AirportService airportService;

    @Mock
    private AirportRepository airportRepository;

    private Airport getAirport() {
        return new Airport(1L, "Warsaw Airport", "WAW", "Warsaw", "Poland", "PL");
    }

    @Test
    public void shouldFetchAllAirports() {
        //Given
        List<Airport> airports = new ArrayList<>();
        airports.add(getAirport());
        airports.add(getAirport());
        airports.add(getAirport());

        when(airportRepository.findAll()).thenReturn(airports);
        //When
        List<Airport> resultList = airportService.getAllAirports();
        //Then
        assertEquals(resultList.size(), 3);
    }

    @Test
    public void shouldFetchAirportsByCountry() {
        //Given
        List<Airport> airports = new ArrayList<>();
        airports.add(getAirport());
        airports.add(new Airport(2L, "Warsaw Modlin Airport", "WMI", "Warsaw", "Poland", "PL"));

        when(airportRepository.findByCountryCode("PL")).thenReturn(airports);
        //When
        List<Airport> resultList = airportService.getAirportsByCountryCode("PL");
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void shouldFetchAirportsByCity() {
        //Given
        List<Airport> airports = new ArrayList<>();
        airports.add(getAirport());
        airports.add(new Airport(2L, "Warsaw Modlin Airport", "WMI", "Warsaw", "Poland", "PL"));

        when(airportRepository.findByCity("Warsaw")).thenReturn(airports);
        //When
        List<Airport> resultList = airportService.getAirportsByCity("Warsaw");
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void shouldFetchAirportById() {
        //Given
        Airport airport = getAirport();

        when(airportRepository.findById(1L)).thenReturn(Optional.of(airport));
        //When
        Optional<Airport> result = airportService.getAirportById(1L);
        //Then
        assertNotNull(result);
    }

    @Test
    public void shouldFetchAirportByIata() {
        //Given
        Airport airport = getAirport();

        when(airportRepository.findByIata("WAW")).thenReturn(Optional.of(airport));
        //When
        Optional<Airport> result = airportService.getAirportByIATA("WAW");
        //Then
        assertNotNull(result);
    }

    @Test
    public void shouldSaveAirport() {
        //Given
        Airport airport = getAirport();

        when(airportRepository.save(airport)).thenReturn(airport);
        //When
        Airport result = airportService.saveAirport(airport);
        //Then
        assertEquals(result.getId(), airport.getId());
        assertEquals(result.getName(), airport.getName());
        assertEquals(result.getIata(), airport.getIata());
        assertEquals(result.getCity(), airport.getCity());
        assertEquals(result.getCountry(), airport.getCountry());
        assertEquals(result.getCountryCode(), airport.getCountryCode());
    }
}
