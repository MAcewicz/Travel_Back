package com.kodilla.travel.repository;

import com.kodilla.travel.domain.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Long> {

    @Override
    List<Airline> findAll();

    @Override
    Optional<Airline> findById(Long id);

    Optional<Airline> findByIataCode(String iataCode);

    @Override
    Airline save(Airline airline);

    @Override
    void deleteById(Long id);
}
