package com.kodilla.travel.mapper;

import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.dto.WeatherDto;
import com.kodilla.travel.mappers.WeatherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherMapperTestSuite {

    @Autowired
    private WeatherMapper weatherMapper;

    @Test
    public void testMapToWeatherDtoList() {
        //Given
        Weather weather = new Weather(2L,"Warsaw", LocalDate.now(),25, "No clouds", "No rainfall");
        Weather weather1 = new Weather(3L,"Krakow", LocalDate.now(),20, "Cloudy", "Small rainfall");
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather);
        weatherList.add(weather1);
        //When
        List<WeatherDto> resultList = weatherMapper.mapToWeatherDtoList(weatherList);
        //Then
        assertEquals(resultList.size(), 2);
    }

    @Test
    public void testMapToWeatherDto() {
        //Given
        Weather weather = new Weather(2L,"Warsaw", LocalDate.now(),25, "No clouds", "No rainfall");
        //When
        WeatherDto weatherDto = weatherMapper.mapToWeatherDto(weather);
        //Then
        assertEquals(weatherDto.getId(), weather.getId());
        assertEquals(weatherDto.getCityName(), weather.getCityName());
        assertEquals(weatherDto.getDate(), weather.getDate());
        assertEquals(weatherDto.getTemperature(), weather.getTemperature());
        assertEquals(weatherDto.getCloudiness(), weather.getCloudiness());
        assertEquals(weatherDto.getRainfall(), weather.getRainfall());
    }

    @Test
    public void testMapToWeather() {
        //Given
        WeatherDto weatherDto = new WeatherDto(2L,"Warsaw", LocalDate.now(),25, "No clouds", "No rainfall");
        //When
        Weather weather = weatherMapper.mapToWeather(weatherDto);
        //Then
        assertEquals(weather.getId(), weatherDto.getId());
        assertEquals(weather.getCityName(), weatherDto.getCityName());
        assertEquals(weather.getDate(), weatherDto.getDate());
        assertEquals(weather.getTemperature(), weatherDto.getTemperature());
        assertEquals(weather.getCloudiness(), weatherDto.getCloudiness());
        assertEquals(weather.getRainfall(), weatherDto.getRainfall());
    }
}
