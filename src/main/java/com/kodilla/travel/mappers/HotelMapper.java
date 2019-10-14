package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.Hotel;
import com.kodilla.travel.dto.HotelDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper {

    public Hotel mapToHotel (HotelDto hotelDto) {
        return new Hotel(hotelDto.getId(),
                hotelDto.getName(),
                hotelDto.getPricePerNight(),
                hotelDto.getCheckIn(),
                hotelDto.getCheckOut());
    }

    public HotelDto mapToHotelDto (Hotel hotel) {
        return new HotelDto(hotel.getId(),
                hotel.getName(),
                hotel.getPricePerNight(),
                hotel.getCheckIn(),
                hotel.getCheckOut());
    }

    public List<HotelDto> mapToHotelDtoList (List<Hotel> hotels) {
        return hotels.stream()
                .map(hotel -> new HotelDto(
                        hotel.getId(),
                        hotel.getName(),
                        hotel.getPricePerNight(),
                        hotel.getCheckIn(),
                        hotel.getCheckOut()))
                .collect(Collectors.toList());
    }
}
