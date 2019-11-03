package com.kodilla.travel.weatherbit;

import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.dto.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class WeatherbitClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String KEY = "944b879389964f659acd3f104670ed87";

    private String getBaseUrl() {
        return "http://api.weatherbit.io/v2.0//forecast/daily?";
    }

    public List<WeatherDto> getForecast(String city) {
        List<Weather> weatherList = new ArrayList<>();
        String country = "";
        URI url = UriComponentsBuilder.fromHttpUrl(getBaseUrl() + "city=" + city + "&country=" + country + "&key=" + KEY)
                .build().encode().toUri();
        return Optional.ofNullable(restTemplate.getForObject(url, WeatherDto[].class))
                .map(Arrays::asList)
                .orElse(new ArrayList<>());
    }
}
