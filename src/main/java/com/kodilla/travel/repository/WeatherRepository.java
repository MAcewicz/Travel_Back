//package com.kodilla.travel.repository;
//
//import com.kodilla.travel.com.kodilla.travel.controller.domain.Weather;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface WeatherRepository extends CrudRepository<Weather, Long> {
//
//    @Override
//    List<Weather> findAll();
//
//    Optional<Weather> findById(Long id);
//
//    Optional<Weather> findByCityName(String name);
//
//    List<Weather> findByTemperatureAndCloudinessAndRainfall(int temp, String cloudiness, String rainfall);
//
//    @Override
//    Weather save(Weather weather);
//
//    @Override
//    void deleteById(Long id);
//}
