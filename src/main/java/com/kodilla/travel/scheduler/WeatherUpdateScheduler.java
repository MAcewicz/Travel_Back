package com.kodilla.travel.scheduler;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.WeatherDto;
import com.kodilla.travel.mappers.WeatherMapper;
import com.kodilla.travel.service.AirportService;
import com.kodilla.travel.service.WeatherService;
import com.kodilla.travel.service.WeatherApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.travel.converter.Distincter.distinctByKey;

@Component
public class WeatherUpdateScheduler {

    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherUpdateScheduler.class);

    private final AirportService airportService;
    private final WeatherService weatherService;
    private final WeatherApiService weatherApiService;
    private final WeatherMapper weatherMapper;

    @Autowired
    public WeatherUpdateScheduler(AirportService airportService, WeatherService weatherService, WeatherApiService weatherApiService, WeatherMapper weatherMapper) {
        this.airportService = airportService;
        this.weatherService = weatherService;
        this.weatherApiService = weatherApiService;
        this.weatherMapper = weatherMapper;
    }

    @Scheduled(cron = "* * 1 * * *")
    public void updateForecast() {
        LOGGER.info("Deleting old weather...");
        weatherService.clearData();
        LOGGER.info("Data cleared.");
        LOGGER.info("Updating weather forecast...");
        List<Airport> airports = airportService.getAllAirports().stream()
                .filter(distinctByKey(Airport::getCity))
                .collect(Collectors.toList());
        for (Airport airport : airports) {
            LOGGER.info(airport.getName() + " - " + airport.getCity());
            List<WeatherDto> weatherDtos = weatherApiService.getForecasts(airport);
            for (WeatherDto weatherDto : weatherDtos) {
                weatherService.saveWeather(weatherMapper.mapToWeather(weatherDto));
            }
        }
        LOGGER.info("Weather forecast updated.");
    }
}
