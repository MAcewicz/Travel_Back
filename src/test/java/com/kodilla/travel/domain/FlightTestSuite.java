package com.kodilla.travel.domain;

import com.kodilla.travel.repository.FlightRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightTestSuite {

    @Autowired
    FlightRepository flightRepository;

    private Flight getFlight() {
        LocalDateTime departureLdt = LocalDateTime.of(2019, 10, 20, 12, 00);
        LocalDateTime arrivalLdt = LocalDateTime.of(2019, 10, 20, 15, 15);
        Timestamp departureTs = Timestamp.valueOf(departureLdt);
        Timestamp arrivalTs = Timestamp.valueOf(arrivalLdt);
        BigDecimal price = new BigDecimal(220.00);
        return new Flight(2L, "PLL Test", "Warsaw", "London", departureTs, arrivalTs, price);
    }

    @Test
    public void testSaveFlight() {
        //Given
        Flight flight = getFlight();
        long beforeSave = flightRepository.count();
        //When
        flightRepository.save(flight);
        long afterSave = flightRepository.count();
        //Then
        long result = afterSave - beforeSave;
        assertEquals(result, 1L);
        //CleanUp
        flightRepository.delete(flight);
    }

    @Test
    public void testDeleteById() {
        //Given
        long before = flightRepository.count();
        Flight flight = getFlight();
        flightRepository.save(flight);
        //When
        flightRepository.deleteById(flight.getId());
        long after = flightRepository.count();
        //Then
        assertEquals(after, 0);
    }

    @Test
    public void testFindAll() {
        //Given
        Flight flight = getFlight();
        flightRepository.save(flight);
        //When
        List<Flight> resultList = flightRepository.findAll();
        //Then
        int result = resultList.size();
        assertEquals(result, 1);
        //CleanUp
        System.out.println(flight.getId());
        flightRepository.deleteById(flight.getId());
    }
}
