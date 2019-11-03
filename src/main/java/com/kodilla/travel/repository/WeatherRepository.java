package com.kodilla.travel.repository;

import com.kodilla.travel.domain.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {

    @Override
    List<Weather> findAll();

    Optional<Weather> findById(Long id);

    Optional<Weather> findByCity(String name);

    List<Weather> findByTemperatureAndCloudinessAndRainfall(int temp, int cloudiness, int rainfall);

    @Override
    Weather save(Weather weather);

    @Override
    void deleteById(Long id);
}
