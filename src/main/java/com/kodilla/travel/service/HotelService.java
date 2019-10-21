package com.kodilla.travel.service;

import com.kodilla.travel.domain.Hotel;
import com.kodilla.travel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(long id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> getHotelsByCity(String city) { return hotelRepository.findByCity(city); }

    public List<Hotel> getHotelsByCityAndPrice(String city, BigDecimal price) {
        return hotelRepository.findByCityAndPricePerNight(city, price);
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(long id) {
        hotelRepository.deleteById(id);
    }
}
