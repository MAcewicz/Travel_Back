package com.kodilla.travel.repository;

import com.kodilla.travel.domain.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

    List<Airport> findAll();

    List<Airport> findByCity(String city);

    List<Airport> findByCountry(String country);

    Optional<Airport> findById(Long id);

    Optional<Airport> findByIata(String iata);

    Optional<Airport> findByName(String name);

    Airport save(Airport airport);

    @Override
    void deleteById(Long id);


}
