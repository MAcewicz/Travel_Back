package com.kodilla.travel.mapper;

import com.kodilla.travel.domain.Hotel;
import com.kodilla.travel.dto.HotelDto;
import com.kodilla.travel.mappers.HotelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelMapperTestSuite {

    @Autowired
    private HotelMapper hotelMapper;

    private Hotel getHotel() {
        BigDecimal pricePerNight = new BigDecimal(50.00);
        Timestamp checkIn = Timestamp.valueOf("2019-11-09 12:00:00");
        Timestamp checkOut = Timestamp.valueOf("2019-11-10 10:30:00");
        return new Hotel(1L, "Test", "Barcelona", pricePerNight, checkIn, checkOut);
    }

    @Test
    public void testMapToHotelDtoList() {
        //Given
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(getHotel());
        hotels.add(getHotel());
        //When
        List<HotelDto> resultList = hotelMapper.mapToHotelDtoList(hotels);
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void testMapToHotelDto() {
        //Given
        Hotel hotel = getHotel();
        //When
        HotelDto result = hotelMapper.mapToHotelDto(hotel);
        //Then
        assertEquals(result.getId(), hotel.getId());
        assertEquals(result.getName(), hotel.getName());
        assertEquals(result.getCity(), hotel.getCity());
        assertEquals(result.getPricePerNight(), hotel.getPricePerNight());
        assertEquals(result.getCheckIn(), hotel.getCheckIn());
        assertEquals(result.getCheckOut(), hotel.getCheckOut());
    }

    @Test
    public void testMapToHotel() {
        //Given
        BigDecimal pricePerNight = new BigDecimal(50.00);
        Timestamp checkIn = Timestamp.valueOf("2019-11-09 12:00:00");
        Timestamp checkOut = Timestamp.valueOf("2019-11-10 10:30:00");
        HotelDto hotelDto = new HotelDto(3L, "Test", "Barcelona", pricePerNight, checkIn, checkOut);
        //When
        Hotel result = hotelMapper.mapToHotel(hotelDto);
        //Then
        assertEquals(result.getId(), hotelDto.getId());
        assertEquals(result.getName(), hotelDto.getName());
        assertEquals(result.getCity(), hotelDto.getCity());
        assertEquals(result.getPricePerNight(), hotelDto.getPricePerNight());
        assertEquals(result.getCheckIn(), hotelDto.getCheckIn());
        assertEquals(result.getCheckOut(), hotelDto.getCheckOut());
    }
}
