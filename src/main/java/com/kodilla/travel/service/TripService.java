package com.kodilla.travel.service;

import com.kodilla.travel.domain.Trip;
import com.kodilla.travel.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public List<Trip> getTripsByUser(Long userId) {
        return tripRepository.findAllByUserId(userId);
    }

    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public void delete(Long id) {
        tripRepository.deleteById(id);
    }
}
