package com.kodilla.travel.controller;

import com.kodilla.travel.dto.HotelDto;
import com.kodilla.travel.exception.HotelNotFoundException;
import com.kodilla.travel.mappers.HotelMapper;
import com.kodilla.travel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/travel/")
@CrossOrigin("*")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    HotelMapper hotelMapper;

    @GetMapping(value = "hotels")
    public List<HotelDto> getHotels() {
        return hotelMapper.mapToHotelDtoList(hotelService.getHotels());
    }

    @GetMapping(value = "hotels/{id}")
    public HotelDto getHotelById(@PathVariable Long id) throws HotelNotFoundException {
        return hotelMapper.mapToHotelDto(hotelService.getHotelById(id).orElseThrow(HotelNotFoundException::new));
    }

    @GetMapping(value = "hotels/city/{city}")
    public List<HotelDto> getHotelsByCity(@PathVariable String city) {
        return hotelMapper.mapToHotelDtoList(hotelService.getHotelsByCity(city));
    }

    @GetMapping(value = "hotels/city/price/{city}/{price}")
    public List<HotelDto> getHotelsByCityAndPrice(@PathVariable String city, @PathVariable BigDecimal price) {
        return hotelMapper.mapToHotelDtoList(hotelService.getHotelsByCityAndPrice(city, price));
    }

    @PutMapping(value = "hotels")
    public HotelDto updateHotel(@RequestBody HotelDto hotelDto) {
        return hotelMapper.mapToHotelDto(hotelService.saveHotel(hotelMapper.mapToHotel(hotelDto)));
    }

    @PostMapping(value = "hotels")
    public void saveHotel(@RequestBody HotelDto hotelDto) {
        hotelService.saveHotel(hotelMapper.mapToHotel(hotelDto));
    }

    @DeleteMapping(value = "hotels/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}
