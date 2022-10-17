package com.kodilla.travel.weather;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.ForecastDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherClient {

    @Value("${weather.key}")
    private String key;

    private final WebClient webClient;


    @Autowired
    public WeatherClient(WebClient webClient) {
        this.webClient = webClient;
    }

    private String getBaseUrl() {
        return "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    }

    public ForecastDto getForecast(Airport airport) {
        URI url = UriComponentsBuilder.fromHttpUrl(getBaseUrl() +
                airport.getCity() +
                "," + airport.getCountryCode() +
                "/?unitGroup=metric" +
                "&lang=en" +
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
