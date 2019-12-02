package com.kodilla.travel.mapper;

import com.kodilla.travel.domain.Airline;
import com.kodilla.travel.dto.AirlineDto;
import com.kodilla.travel.mappers.AirlineMapper;
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
public class AirlineMapperTestSuite {

    @Autowired
    private AirlineMapper airlineMapper;

    @Test
    public void testMapToAirline() {
        //Given
        AirlineDto airlineDto = new AirlineDto(2L, "Moje Airline", "MJA");
        //When
        Airline airline = airlineMapper.mapToAirline(airlineDto);
        //Then
        assertEquals(airline.getId(), airlineDto.getId());
        assertEquals(airline.getName(), airlineDto.getName());
        assertEquals(airline.getIataCode(), airlineDto.getIataCode());
    }

    @Test
    public void testMapToAirlineDto() {
        //Given
        Airline airline = new Airline(2L, "Moje Airline", "MJA");
        //When
        AirlineDto airlineDto = airlineMapper.mapToAirlineDto(airline);
        //Then
        assertEquals(airlineDto.getId(), airline.getId());
        assertEquals(airlineDto.getName(), airline.getName());
        assertEquals(airlineDto.getIataCode(), airline.getIataCode());
    }

    @Test
    public void testMapToAirlineDtoList() {
        //Given
        List<Airline> airlines = new ArrayList<>();
        airlines.add(new Airline(1L, "Linia 1", "LN1"));
        airlines.add(new Airline(2L, "Linia 2", "LN2"));
        //When
        List<AirlineDto> airlineDtoList = airlineMapper.mapToAirlineDtoList(airlines);
        //Then
        assertEquals(airlineDtoList.size(), 2);
    }
}
