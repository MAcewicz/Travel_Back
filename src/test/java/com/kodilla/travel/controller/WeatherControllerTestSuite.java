package com.kodilla.travel.controller;

import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.dto.WeatherDto;
import com.kodilla.travel.mappers.WeatherMapper;
import com.kodilla.travel.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @MockBean
    private WeatherMapper weatherMapper;

    @Test
    public void shouldFetchAllWeather() throws Exception {
        //Given
        LocalDate date = LocalDate.of(2019, 11, 1);
        WeatherDto weather1 = new WeatherDto(1L, "Warsaw", date, 15, 0, 0);
        WeatherDto weather2 = new WeatherDto(2L, "Gdansk", date, 20, 55, 95);
        List<WeatherDto> weatherList = new ArrayList<>();
        weatherList.add(weather1);
        weatherList.add(weather2);

        when(weatherMapper.mapToWeatherDtoList(weatherService.getWeatherList())).thenReturn(weatherList);
        //When & Then
        mockMvc.perform(get("/v1/travel/weather"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].city_name", is("Warsaw")))
                .andExpect(jsonPath("$[0].temp", is(15)))
                .andExpect(jsonPath("$[0].clouds", is(0)))
                .andExpect(jsonPath("$[0].pop", is(0)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].city_name", is("Gdansk")))
                .andExpect(jsonPath("$[1].temp", is(20)))
                .andExpect(jsonPath("$[1].clouds", is(55)))
                .andExpect(jsonPath("$[1].pop", is(95)));
    }

    @Test
    public void shouldFetchWeatherById() throws Exception {
        //Given
        LocalDate date = LocalDate.of(2019, 11, 30);
        WeatherDto weatherDto = new WeatherDto(2L, "Warsaw", date, 20, 0, 0);
        Weather weather = new Weather(2L, "Warsaw", date, 20, 0, 0);

        when(weatherService.getWeatherById(2L)).thenReturn(Optional.of(weather));
        when(weatherMapper.mapToWeatherDto(weather)).thenReturn(weatherDto);
        //When & Then
        mockMvc.perform(get("/v1/travel/weather/id/{id}", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.city_name", is("Warsaw")))
                .andExpect(jsonPath("$.temp", is(20)))
                .andExpect(jsonPath("$.clouds", is(0)))
                .andExpect(jsonPath("$.pop", is(0)));
    }

    @Test
    public void shouldFetchWeatherByCity() throws Exception {
        //Given
        LocalDate date = LocalDate.of(2019, 11, 30);
        WeatherDto weatherDto = new WeatherDto(2L, "Warsaw", date, 20, 0, 0);
        Weather weather = new Weather(2L, "Warsaw", date, 20, 0, 0);

        when(weatherService.getWeatherByCity("Warsaw")).thenReturn(Optional.of(weather));
        when(weatherMapper.mapToWeatherDto(weather)).thenReturn(weatherDto);
        //When & Then
        mockMvc.perform(get("/v1/travel/weather/city/{city}", "Warsaw"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.city_name", is("Warsaw")))
                .andExpect(jsonPath("$.temp", is(20)))
                .andExpect(jsonPath("$.clouds", is(0)))
                .andExpect(jsonPath("$.pop", is(0)));
    }


    @Test
    public void shouldFetchWeatherByConditions() throws Exception {
        //Given
        LocalDate date = LocalDate.of(2019, 11, 30);
        WeatherDto weatherDto = new WeatherDto(2L, "Warsaw", date, 20, 0, 0);
        List<WeatherDto> weatherDtoList = new ArrayList<>();
        weatherDtoList.add(weatherDto);
        Weather weather = new Weather(2L, "Warsaw", date, 20, 0, 0);
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather);

        when(weatherService.getWeatherByConditions(20, 0, 0)).thenReturn(weatherList);
        when(weatherMapper.mapToWeatherDtoList(weatherList)).thenReturn(weatherDtoList);
        //When & THen
        mockMvc.perform(get("/v1/travel/weather/cond/{temp}/{cloudiness}/{rainfall}", 20, 0, 0)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].city_name", is("Warsaw")))
                .andExpect(jsonPath("$[0].temp", is(20)))
                .andExpect(jsonPath("$[0].clouds", is(0)))
                .andExpect(jsonPath("$[0].pop", is(0)));
    }

    @Test
    public void shouldUpdateWeather() throws Exception {
//        //Given
//        LocalDate date = LocalDate.of(2019, 11, 30);
//        WeatherDto weatherDto = new WeatherDto(2L, "Warsaw", date, 20, 0, 0);
//        WeatherDto newWeatherDto = new WeatherDto(2L, "Warsaw", date, 15, 25, 10);
//
//        Gson gson = new Gson();
//        String weatherJson = gson.toJson(weatherDto);
//
//        when(weatherMapper.mapToWeatherDto(weatherService.saveWeather(weatherMapper.mapToWeather(newWeatherDto))))
//                .thenReturn(newWeatherDto);
//        //When & Then
//        mockMvc.perform(post("/v1/travel/weather")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(weatherJson))
//                .andExpect(status().isOk());
    }

    @Test
    public void shouldSaveWeather() throws Exception {
//        //Given
//        LocalDate date = LocalDate.of(2019, 11, 30);
//        WeatherDto weatherDto = new WeatherDto(2L, "Warsaw", date, 20, 0, 0);
//        Gson gson = new Gson();
//        String weatherJson = gson.toJson(weatherDto);
//
//        //When & Then
//        mockMvc.perform(post("/v1/travel/weather")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(weatherJson))
//                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteWeather() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(delete("/v1/travel/weather/{id}", 1))
                .andExpect(status().isOk());
    }
}
