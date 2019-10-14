package com.kodilla.travel.repository;

import com.kodilla.travel.domain.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {

    @Override
    List<Hotel> findAll();

    @Override
    Optional<Hotel> findById(Long id);

    Optional<Hotel> findByName(String name);

    List<Hotel> findByPricePerNight(BigDecimal price);

    @Override
    Hotel save(Hotel hotel);

    @Override
    void deleteById(Long id);
}
