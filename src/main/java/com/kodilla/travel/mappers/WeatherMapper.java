package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.Weather;
import com.kodilla.travel.dto.WeatherDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherMapper {

    public Weather mapToWeather (WeatherDto weatherDto) {
        return new Weather(weatherDto.getId(),
                weatherDto.getCityName(),
                weatherDto.getDate(),
                weatherDto.getTemperature(),
                weatherDto.getCloudiness(),
                weatherDto.getRainfall());
    }

    public WeatherDto mapToWeatherDto (Weather weather) {
        return new WeatherDto(weather.getId(),
                weather.getCityName(),
                weather.getDate(),
                weather.getTemperature(),
                weather.getCloudiness(),
                weather.getRainfall());
    }

    public List<WeatherDto> mapToWeatherDtoList (List<Weather> weatherList) {
        return weatherList.stream()
                .map(weather -> new WeatherDto(
                        weather.getId(),
                        weather.getCityName(),
                        weather.getDate(),
                        weather.getTemperature(),
                        weather.getCloudiness(),
                        weather.getRainfall()))
                .collect(Collectors.toList());
    }
}
