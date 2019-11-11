package com.kodilla.travel.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.kodilla.travel.dto.ForecastDto;
import com.kodilla.travel.dto.WeatherDto;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForecastDeserializer extends JsonDeserializer<ForecastDto> {

    @Override
    public ForecastDto deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode weatherNode = jp.getCodec().readTree(jp);

        String city = weatherNode.get("city_name").textValue();

        ForecastDto forecastDto = new ForecastDto();
        forecastDto.setCity(city);

        List<WeatherDto> dtos = new ArrayList<>();

        Iterator<JsonNode> itr = weatherNode.get("data").elements();

        while (itr.hasNext()) {
            JsonNode node = itr.next();
            WeatherDto weatherDto = new WeatherDto();

            weatherDto.setCity(city);
            weatherDto.setDate(LocalDate.parse(node.get("valid_date").textValue()));
            weatherDto.setTemperature(node.get("temp").intValue());
            weatherDto.setCloudiness(node.get("clouds").intValue());
            weatherDto.setRainfall(node.get("pop").intValue());

            dtos.add(weatherDto);
        }
        forecastDto.setWeatherDtos(dtos);

        return forecastDto;
    }
}
