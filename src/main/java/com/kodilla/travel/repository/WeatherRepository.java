package com.kodilla.travel.repository;

import com.kodilla.travel.domain.Weather;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {

    @Override
    List<Weather> findAll();

    List<Weather> findByCity(String city);

    Optional<Weather> findById(Long id);

    Optional<Weather> findByCityAndDate(String name, LocalDate date);

    @Query(nativeQuery = true)
    List<Weather> getGoodConditions(@Param("TEMP") int temp, @Param("CLOUDS") int cloudiness, @Param("RAIN") int rainfall);

    @Modifying
    @Transactional
    @Query(nativeQuery = true)
    void clearData();

    @Override
    Weather save(Weather weather);

    @Override
    void deleteById(Long id);
}
