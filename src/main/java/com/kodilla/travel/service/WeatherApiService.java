package com.kodilla.travel.service;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.WeatherDto;
import com.kodilla.travel.weather.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherApiService {

    private final WeatherClient weatherClient;

    @Autowired
    public WeatherApiService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public List<WeatherDto> getForecasts(Airport airport) {
        return weatherClient.getForecast(airport).getWeatherDtos();
    }
}
