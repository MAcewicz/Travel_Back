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

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        WeatherDto weather1 = new WeatherDto(1L, "Warsaw", date, 15, "Clear sky", "No rainfall");
        WeatherDto weather2 = new WeatherDto(2L, "Gdansk", date, 15, "Clear sky", "No rainfall");
        List<WeatherDto> weatherList = new ArrayList<>();
        weatherList.add(weather1);
        weatherList.add(weather2);

        when(weatherMapper.mapToWeatherDtoList(weatherService.getWeatherList())).thenReturn(weatherList);
        //When & Then
        mockMvc.perform(get("/v1/travel/weather").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}
