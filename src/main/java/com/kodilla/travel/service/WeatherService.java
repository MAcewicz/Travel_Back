package com.kodilla.travel.service;

import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kodilla.travel.converter.Distinctor.distinctByKey;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> getWeatherList() {
        return weatherRepository.findAll();
    }

    public List<Weather> getWeatherByCity(String city) {
        return weatherRepository.findByCity(city);
    }

    public Optional<Weather> getWeatherById(long id) {
        return weatherRepository.findById(id);
    }

    public Optional<Weather> getWeatherByCityAndDate(String city, LocalDate date) {
        return weatherRepository.findByCityAndDate(city, date);
    }

    public List<Weather> getWeatherByConditions(int temp, int cloud, int rainfall) {
        List<Weather> weatherList = weatherRepository.getGoodConditions(temp, cloud, rainfall);
        Collections.sort(weatherList);
        return weatherList.stream()
                .filter(distinctByKey(Weather::getCity))
                .collect(Collectors.toList());
    }

    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public void clearData() {
        weatherRepository.clearData();
    }

    public void delete(long id) {
        weatherRepository.deleteById(id);
    }
}
