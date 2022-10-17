package com.kodilla.travel.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.kodilla.travel.dto.ForecastDto;
import com.kodilla.travel.dto.WeatherDto;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForecastDeserializer extends JsonDeserializer<ForecastDto> {

    @Override
    public ForecastDto deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        JsonNode weatherNode = jp.getCodec().readTree(jp);
        String resolvedAddress = weatherNode.get("resolvedAddress").textValue();
        List<String> address = new ArrayList<String>(Arrays.asList(resolvedAddress.split("\\s*,\\s*")));
        String city = address.get(0);


        ForecastDto forecastDto = new ForecastDto();
        List<WeatherDto> dtos = new ArrayList<>();

        Iterator<JsonNode> itr = weatherNode.get("days").elements();

        while (itr.hasNext()) {
            JsonNode node = itr.next();
            WeatherDto weatherDto = new WeatherDto();

            weatherDto.setCity(city);
            weatherDto.setDate(LocalDate.parse(node.get("datetime").textValue()));
            weatherDto.setTemperature(node.get("temp").intValue());
            weatherDto.setCloudiness(node.get("cloudcover").intValue());
            weatherDto.setRainfall(node.get("precipprob").intValue());

            dtos.add(weatherDto);
        }
        forecastDto.setWeatherDtos(dtos);

        return forecastDto;
    }
}
