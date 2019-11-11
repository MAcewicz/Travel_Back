package com.kodilla.travel.weatherbit;

import com.kodilla.travel.dto.ForecastDto;
import com.kodilla.travel.dto.WeatherDto;
import com.kodilla.travel.exception.AirportNotFoundException;
import com.kodilla.travel.mappers.WeatherMapper;
import com.kodilla.travel.service.AirportService;
import com.kodilla.travel.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherBitTestSuite {

    @Autowired
    private WeatherbitClient weatherbitClient;

    @Autowired
    private AirportService airportService;

    @Test
    public void testGetLongForecast() throws AirportNotFoundException {
        ForecastDto forecastDto = weatherbitClient.getForecast(airportService.getAirportByIATA("PRG")
                .orElseThrow(AirportNotFoundException::new));

        List<WeatherDto> weatherDtoList = forecastDto.getWeatherDtos();

        for (WeatherDto weatherDto : weatherDtoList) {
            System.out.println(weatherDto);
        }
    }
}
