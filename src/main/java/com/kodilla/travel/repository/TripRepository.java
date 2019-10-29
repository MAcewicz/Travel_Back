package com.kodilla.travel.repository;

import com.kodilla.travel.domain.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {

    @Override
    List<Trip> findAll();

    List<Trip> findAllByUserId(Long userId);

    @Override
    Optional<Trip> findById(Long id);

    @Override
    Trip save(Trip trip);

    @Override
    void deleteById(Long id);
}
