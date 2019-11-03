package com.kodilla.travel.controller;

import com.kodilla.travel.dto.WeatherDto;
import com.kodilla.travel.exception.WeatherNotFoundException;
import com.kodilla.travel.mappers.WeatherMapper;
import com.kodilla.travel.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/travel/")
@CrossOrigin("*")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @Autowired
    WeatherMapper weatherMapper;

    @GetMapping(value = "weather")
    public List<WeatherDto> getWeatherList() {
        return weatherMapper.mapToWeatherDtoList(weatherService.getWeatherList());
    }

    @GetMapping(value = "weather/id/{id}")
    public WeatherDto getWeatherById(@PathVariable Long id) throws WeatherNotFoundException {
        return weatherMapper.mapToWeatherDto(weatherService.getWeatherById(id).orElseThrow(WeatherNotFoundException::new));
    }

    @GetMapping(value = "weather/city/{city}")
    public WeatherDto getWeatherByCity(@PathVariable String city) throws WeatherNotFoundException {
        return weatherMapper.mapToWeatherDto(weatherService.getWeatherByCity(city).orElseThrow(WeatherNotFoundException::new));
    }

    @GetMapping(value = "weather/cond/{temp}/{cloudiness}/{rainfall}")
    public List<WeatherDto> getWeatherByConditions(@PathVariable int temp, @PathVariable int cloudiness, @PathVariable int rainfall) {
        return weatherMapper.mapToWeatherDtoList(weatherService.getWeatherByConditions(temp, cloudiness, rainfall));
    }

    @PutMapping(value = "weather")
    public WeatherDto updateWeather(@RequestBody WeatherDto weatherDto) {
        return weatherMapper.mapToWeatherDto(weatherService.saveWeather(weatherMapper.mapToWeather(weatherDto)));
    }

    @PostMapping(value = "weather")
    public void saveWeather(@RequestBody WeatherDto weatherDto) {
        weatherService.saveWeather(weatherMapper.mapToWeather(weatherDto));
    }

    @DeleteMapping(value = "weather/{id}")
    public void deleteWeather(@PathVariable Long id) {
        weatherService.delete(id);
    }
}
