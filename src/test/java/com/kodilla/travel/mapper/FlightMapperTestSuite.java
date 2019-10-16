package com.kodilla.travel.mapper;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.dto.FlightDto;
import com.kodilla.travel.mappers.FlightMapper;
import org.junit.Assert;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightMapperTestSuite {

    @Autowired
    FlightMapper flightMapper;

    @Test
    public void testMapToFlight() {
        //Given
        LocalDateTime departureLdt = LocalDateTime.of(2019, 10, 20, 12, 00);
        LocalDateTime arrivalLdt = LocalDateTime.of(2019, 10, 20, 15, 15);
        Timestamp departureTs = Timestamp.valueOf(departureLdt);
        Timestamp arrivalTs = Timestamp.valueOf(arrivalLdt);
        BigDecimal price = new BigDecimal(220.00);
        FlightDto flightDto = new FlightDto(3L, "PLL Test", "Warsaw", "London", departureTs, arrivalTs, price);
        //When
        Flight flight = flightMapper.mapToFlight(flightDto);
        //Then
        assertEquals(flight.getId(), flightDto.getId());
        assertEquals(flight.getAirline(), flightDto.getAirline());
        assertEquals(flight.getAirport(), flightDto.getAirport());
        assertEquals(flight.getDestination(), flightDto.getDestination());
        assertEquals(flight.getDeparture(), flightDto.getDeparture());
        assertEquals(flight.getArrival(), flightDto.getArrival());
        assertEquals(flight.getPrice(), flightDto.getPrice());
    }

    @Test
    public void testMapToFlightDto() {
        //Given
        LocalDateTime departureLdt = LocalDateTime.of(2019, 10, 20, 12, 00);
        LocalDateTime arrivalLdt = LocalDateTime.of(2019, 10, 20, 15, 15);
        Timestamp departureTs = Timestamp.valueOf(departureLdt);
        Timestamp arrivalTs = Timestamp.valueOf(arrivalLdt);
        BigDecimal price = new BigDecimal(220.00);
        Flight flight = new Flight(3L, "PLL Test", "Warsaw", "London", departureTs, arrivalTs, price);
        //When
        FlightDto flightDto = flightMapper.mapToFlightDto(flight);
        //Then
        assertEquals(flightDto.getId(), flight.getId());
        assertEquals(flightDto.getAirline(), flight.getAirline());
        assertEquals(flightDto.getAirport(), flight.getAirport());
        assertEquals(flightDto.getDestination(), flight.getDestination());
        assertEquals(flightDto.getDeparture(), flight.getDeparture());
        assertEquals(flightDto.getArrival(), flight.getArrival());
        assertEquals(flightDto.getPrice(), flight.getPrice());
    }

    @Test
    public void testMapToFlightDtoList() {
        //Given
        LocalDateTime departureLdt = LocalDateTime.of(2019, 10, 20, 12, 00);
        LocalDateTime arrivalLdt = LocalDateTime.of(2019, 10, 20, 15, 15);
        Timestamp departureTs = Timestamp.valueOf(departureLdt);
        Timestamp arrivalTs = Timestamp.valueOf(arrivalLdt);
        BigDecimal price = new BigDecimal(220.00);
        Flight flight1 = new Flight(3L, "PLL Test", "Warsaw", "London", departureTs, arrivalTs, price);
        Flight flight2 = new Flight(4L, "PLL Test", "Warsaw", "London", departureTs, arrivalTs, price);
        Flight flight3 = new Flight(5L, "PLL Test", "Warsaw", "London", departureTs, arrivalTs, price);
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        //When
        List<FlightDto> flightDtos = flightMapper.mapToFlightDtoList(flights);
        //Then
        assertEquals(flightDtos.size(), 3);
    }
}
