package com.kodilla.travel.weatherbit;

import com.kodilla.travel.dto.ForecastDto;
import com.kodilla.travel.exception.AirportNotFoundException;
import com.kodilla.travel.service.AirportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherBitTestSuite {

    @Autowired
    private WeatherbitClient weatherbitClient;

    @Autowired
    private AirportService airportService;

    @Test
    public void testGetLongForecast() throws AirportNotFoundException {
        //Given
        //When
        ForecastDto forecastDto = weatherbitClient.getForecast(airportService.getAirportByIATA("PRG")
                .orElseThrow(AirportNotFoundException::new));
        //Then
        assertEquals(forecastDto.getWeatherDtos().size(), 16);
    }
}
