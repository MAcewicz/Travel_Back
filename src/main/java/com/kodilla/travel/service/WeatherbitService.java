package com.kodilla.travel.service;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.WeatherDto;
import com.kodilla.travel.weatherbit.WeatherbitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherbitService {

    @Autowired
    private WeatherbitClient weatherbitClient;

    public List<WeatherDto> getForecasts(Airport airport) {
        return weatherbitClient.getForecast(airport).getWeatherDtos();
    }
}
