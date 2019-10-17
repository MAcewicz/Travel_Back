package com.kodilla.travel.service;

import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.exception.WeatherNotFoundException;
import com.kodilla.travel.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public List<Weather> getWeatherList() {
        return weatherRepository.findAll();
    }

    public Optional<Weather> getWeatherById(long id) {
        return weatherRepository.findById(id);
    }

    public Optional<Weather> getWeatherByCity(String city) {
        return weatherRepository.findByCityName(city);
    }

    public List<Weather> getWeatherByConditions(int temp, String cloud, String rainfall) {
        return weatherRepository.findByTemperatureAndCloudinessAndRainfall(temp, cloud, rainfall);
    }

    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public void delete(long id) {
        weatherRepository.deleteById(id);
    }
}
