package com.kodilla.travel.service;

import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.exception.WeatherNotFoundException;
import com.kodilla.travel.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kodilla.travel.converter.Distincter.distinctByKey;

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

    public Weather getWeatherById(long id) {
        try {
            return weatherRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw  new WeatherNotFoundException();
        }
    }

    public Weather getWeatherByCityAndDate(String city, LocalDate date) {
        try {
            return weatherRepository.findByCityAndDate(city, date).get();
        } catch (NoSuchElementException e) {
            throw new WeatherNotFoundException();
        }

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
