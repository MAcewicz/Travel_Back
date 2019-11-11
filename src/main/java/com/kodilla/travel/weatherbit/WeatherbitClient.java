package com.kodilla.travel.weatherbit;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.ForecastDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherbitClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weatherbit.key}")
    private String key;

    private String getBaseUrl() {
        return "http://api.weatherbit.io/v2.0//forecast/daily?";
    }

    public ForecastDto getForecast(Airport airport) {
        URI url = UriComponentsBuilder.fromHttpUrl(getBaseUrl() +
                "city=" + airport.getCity() +
                "&country=" + airport.getCountryCode() +
                "&key=" + key)
                .build()
                .encode()
                .toUri();

        return restTemplate.getForObject(url, ForecastDto.class);
    }
}
