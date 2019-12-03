package com.kodilla.travel.scheduler;

import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.dto.WeatherDto;
import com.kodilla.travel.mappers.WeatherMapper;
import com.kodilla.travel.service.AirportService;
import com.kodilla.travel.service.WeatherService;
import com.kodilla.travel.service.WeatherbitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class WeatherUpdateScheduler {

    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherUpdateScheduler.class);

    @Autowired
    private AirportService airportService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherbitService weatherbitService;

    @Autowired
    private WeatherMapper weatherMapper;

    @Scheduled(cron = "0 0 1 * * *")
    public void deleteOldWeather() {
        LOGGER.info("Deleting old weather...");
        weatherService.clearData();
        LOGGER.info("Data cleared.");
    }

    @Scheduled(cron = "0 0 2 * * *")
    public void updateForecats() {
        LOGGER.info("Updating weather forecast...");
        List<Airport> airports = airportService.getAllAirports();
        for (Airport airport : airports) {
            LOGGER.info(airport.getName() + " " + airport.getCity());
            List<WeatherDto> weatherDtos = weatherbitService.getForecasts(airport);
            for (WeatherDto weatherDto : weatherDtos) {
                weatherService.saveWeather(weatherMapper.mapToWeather(weatherDto));
            }
        }
        LOGGER.info("Weather forecast updated.");
    }
}
