package com.kodilla.travel.service;

import com.kodilla.travel.domain.Hotel;
import com.kodilla.travel.repository.HotelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTestSuite {

    @InjectMocks
    private HotelService hotelService;

    @Mock
    private HotelRepository hotelRepository;

    private Hotel getHotel() {
        BigDecimal pricePerNight = new BigDecimal(50.00);
        Timestamp checkIn = Timestamp.valueOf("2019-11-09 12:00:00");
        Timestamp checkOut = Timestamp.valueOf("2019-11-10 10:30:00");
        return new Hotel(3L, "Test", "Barcelona", pricePerNight, checkIn, checkOut);
    }

    @Test
    public void shouldFetchAllHotels() {
        //Given
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(getHotel());
        hotels.add(getHotel());
        hotels.add(getHotel());

        when(hotelRepository.findAll()).thenReturn(hotels);
        //When
        List<Hotel> resultList = hotelService.getHotels();
        //Then
        assertEquals(resultList.size(), 3);
    }

    @Test
    public void shouldFetchHotelById() {
        //Given
        when(hotelRepository.findById(3L)).thenReturn(java.util.Optional.of(getHotel()));
        //When
        Optional<Hotel> result = hotelService.getHotelById(3L);
        //Then
        assertNotNull(result);
    }

    @Test
    public void shouldFetchHotelsByCity() {
        //Given
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(getHotel());
        hotels.add(getHotel());

        when(hotelRepository.findByCity("Barcelona")).thenReturn(hotels);
        //When
        List<Hotel> resultList = hotelService.getHotelsByCity("Barcelona");
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void shouldFetchHotelsByCityAndPrice() {
        //Given
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(getHotel());
        hotels.add(getHotel());
        hotels.add(getHotel());

        when(hotelRepository.findByCityAndPricePerNight("Barcelona", new BigDecimal(50.00))).thenReturn(hotels);
        //When
        List<Hotel> resultList = hotelService.getHotelsByCityAndPrice("Barcelona", new BigDecimal(50.00));
        //Then
        assertEquals(resultList.size(), 3);
    }

    @Test
    public void shouldUpdateHotel() {
        //Given
        Hotel hotel = getHotel();
        BigDecimal pricePerNight = new BigDecimal(40.00);
        Timestamp checkIn = Timestamp.valueOf("2019-10-09 12:00:00");
        Timestamp checkOut = Timestamp.valueOf("2019-10-10 10:30:00");
        Hotel result = new Hotel(1L, "Testing", "Warsaw", pricePerNight, checkIn, checkOut);
        when(hotelRepository.save(hotel)).thenReturn(hotel);
        //When
        result = hotelService.saveHotel(hotel);
        //Then
        assertEquals(result.getId(), hotel.getId());
        assertEquals(result.getName(), hotel.getName());
        assertEquals(result.getCity(), hotel.getCity());
        assertEquals(result.getPricePerNight(), hotel.getPricePerNight());
        assertEquals(result.getCheckIn(), hotel.getCheckIn());
        assertEquals(result.getCheckOut(), hotel.getCheckOut());
    }
}
