package com.kodilla.travel.weatherbit;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.ForecastDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherbitClient {

    @Value("${weatherbit.key}")
    private String key;

    private final WebClient webClient;


    @Autowired
    public WeatherbitClient(WebClient webClient) {
        this.webClient = webClient;
    }

    private String getBaseUrl() {
        return "https://api.weatherbit.io/v2.0//forecast/daily?";
    }

    public ForecastDto getForecast(Airport airport) {
        URI url = UriComponentsBuilder.fromHttpUrl(getBaseUrl() +
                "city=" + airport.getCity() +
                "&country=" + airport.getCountryCode() +
                "&key=" + key)
                .build()
                .encode()
                .toUri();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(ForecastDto.class)
                .block();
    }
}
