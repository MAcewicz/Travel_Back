package com.kodilla.travel.mapper;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.AirportDto;
import com.kodilla.travel.mappers.AirportMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirportMapperTestSuite {

    @Autowired
    private AirportMapper airportMapper;

    @Test
    public void testMapToAirportDtoList() {
        //Given
        List<Airport> airports = new ArrayList<>();
        airports.add(new Airport(1L, "Gdansk", "Poland", "PL", "GDN", "Gdansk"));
        airports.add(new Airport(2L, "Warsaw", "Poland", "PL", "WAW", "Warsaw Chopin"));
        //When
        List<AirportDto> resultList = airportMapper.mapToAirportDtoList(airports);
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void testMapToAirportDto() {
        //Given
        Airport airport = new Airport(1L, "Gdansk", "Poland", "PL", "GDN", "Gdansk");
        //When
        AirportDto result = airportMapper.mapToAirportDto(airport);
        //Then
        assertEquals(result.getId(), airport.getId());
        assertEquals(result.getName(), airport.getName());
        assertEquals(result.getIata(), airport.getIata());
        assertEquals(result.getCity(), airport.getCity());
        assertEquals(result.getCountry(), airport.getCountry());
        assertEquals(result.getCountryCode(), airport.getCountryCode());
    }

    @Test
    public void testMapToAirport() {
        //Given
        AirportDto airportDto = new AirportDto(1L, "Gdansk", "Poland", "PL", "GDN", "Gdansk");
        //When
        Airport result = airportMapper.mapToAirport(airportDto);
        //Then
        assertEquals(result.getId(), airportDto.getId());
        assertEquals(result.getName(), airportDto.getName());
        assertEquals(result.getIata(), airportDto.getIata());
        assertEquals(result.getCity(), airportDto.getCity());
        assertEquals(result.getCountry(), airportDto.getCountry());
        assertEquals(result.getCountryCode(), airportDto.getCountryCode());
    }
}
