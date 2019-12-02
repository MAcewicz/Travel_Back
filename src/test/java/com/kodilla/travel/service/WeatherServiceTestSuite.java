package com.kodilla.travel.service;

import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.repository.WeatherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTestSuite {

    @InjectMocks
    private WeatherService weatherService;

    @Mock
    private WeatherRepository weatherRepository;

    @Test
    public void shouldSaveWeather() {
        //Given
        Weather weather = new Weather(3L, "Warsaw", LocalDate.now(),25, 0, 0);

        when(weatherRepository.save(weather)).thenReturn(weather);
        //When
        Weather result = weatherService.saveWeather(weather);
        //Then
        assertEquals(result.getId(), weather.getId());
        assertEquals(result.getCity(), weather.getCity());
        assertEquals(result.getTemperature(), weather.getTemperature());
        assertEquals(result.getCloudiness(), weather.getCloudiness());
        assertEquals(result.getRainfall(), weather.getRainfall());
    }

    @Test
    public void shouldFetchWeatherList() {
        //Given
        Weather weather = new Weather(3L, "Warsaw", LocalDate.now(), 25, 0, 0);
        Weather weather1 = new Weather(4L, "Warsaw", LocalDate.now(), 25, 0, 0);
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather);
        weatherList.add(weather1);

        when(weatherRepository.findAll()).thenReturn(weatherList);
        //When
        List<Weather> resultList = weatherService.getWeatherList();
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void shouldFetchWeatherById() {
        //Given
        Weather weather = new Weather(3L, "Warsaw", LocalDate.now(), 25, 0, 0);

        when(weatherRepository.findById(3L)).thenReturn(java.util.Optional.of(weather));
        //When
        Optional<Weather> result = weatherService.getWeatherById(3L);
        //Then
        assertNotNull(result);
    }

    @Test
    public void shouldFetchWeatherByCity() {
        //Given
        LocalDate date = LocalDate.now();
        Weather weather = new Weather(3L, "Warsaw", LocalDate.now(), 25, 0, 0);

        when(weatherRepository.findByCityAndDate("Warsaw", date)).thenReturn(Optional.of(weather));
        //When
        Optional<Weather> result = weatherService.getWeatherByCityAndDate("Warsaw", date);
        //Then
        assertNotNull(result);
    }
}
