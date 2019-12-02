package com.kodilla.travel.amadeus;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.kodilla.travel.converter.TimeConverter;
import com.kodilla.travel.domain.Airline;
import com.kodilla.travel.domain.Airport;
import com.kodilla.travel.dto.FlightDto;
import com.kodilla.travel.exception.AirlineNotFoundException;
import com.kodilla.travel.exception.AirportNotFoundException;
import com.kodilla.travel.service.AirlineService;
import com.kodilla.travel.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AmadeusClient {

    @Autowired
    private TimeConverter timeConverter;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirlineService airlineService;

    private Amadeus amadeus = Amadeus
            .builder(System.getenv())
            .build();

    public List<FlightDto> getLowFare(String origin, String destination, LocalDate date) throws ResponseException, AirportNotFoundException, AirlineNotFoundException {

        String departureDate = date.toString();

        FlightOffer[] flightOffers = amadeus.shopping.flightOffers.get(Params
                .with("origin", origin)
                .and("destination", destination)
                .and("departureDate", departureDate)
                .and("nonStop", "true")
                .and("max", "10"));

        JsonArray jsonElements = flightOffers[0].getResponse().getResult().getAsJsonArray("data");
        List<FlightDto> flightDtos = new ArrayList<>();

        for (JsonElement jsonElement : jsonElements) {
            FlightDto flightDto = new FlightDto();

            BigDecimal price = jsonElement
                    .getAsJsonObject()
                    .getAsJsonArray("offerItems")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("price")
                    .getAsJsonPrimitive("total")
                    .getAsBigDecimal();

            String departure = jsonElement
                    .getAsJsonObject()
                    .getAsJsonArray("offerItems")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonArray("services")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonArray("segments")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("flightSegment")
                    .getAsJsonObject("departure")
                    .getAsJsonPrimitive("at")
                    .getAsString();

            String arrival = jsonElement
                    .getAsJsonObject()
                    .getAsJsonArray("offerItems")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonArray("services")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonArray("segments")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("flightSegment")
                    .getAsJsonObject("arrival")
                    .getAsJsonPrimitive("at")
                    .getAsString();

            String airlineCode = jsonElement
                    .getAsJsonObject()
                    .getAsJsonArray("offerItems")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonArray("services")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonArray("segments")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("flightSegment")
                    .getAsJsonPrimitive("carrierCode")
                    .getAsString();

            Timestamp arrivalTs = timeConverter.toTimestamp(arrival);
            Timestamp departureTs = timeConverter.toTimestamp(departure);

            Airport originAirport = airportService.getAirportByIATA(origin).orElseThrow(AirportNotFoundException::new);
            Airport destinationAirport = airportService.getAirportByIATA(destination).orElseThrow(AirportNotFoundException::new);

            Airline airline = airlineService.getAirlineByIata(airlineCode).orElseThrow(AirlineNotFoundException::new);

            flightDto.setAirport(originAirport.getName());
            flightDto.setDestination(destinationAirport.getName());
            flightDto.setPrice(price);
            flightDto.setDeparture(departureTs);
            flightDto.setArrival(arrivalTs);
            flightDto.setAirline(airline.getName());

            flightDtos.add(flightDto);
        }

        return flightDtos;
    }
}
