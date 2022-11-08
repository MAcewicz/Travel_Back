package com.kodilla.travel.amadeus;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AmadeusClient {

    private final static Logger LOGGER = LoggerFactory.getLogger(AmadeusClient.class);

    private final TimeConverter timeConverter;
    private final AirportService airportService;
    private final AirlineService airlineService;

    private final Amadeus amadeus = Amadeus
            .builder(System.getenv())
            .build();

    @Autowired
    public AmadeusClient(TimeConverter timeConverter, AirportService airportService, AirlineService airlineService) {
        this.timeConverter = timeConverter;
        this.airportService = airportService;
        this.airlineService = airlineService;
    }

    public List<FlightDto> getLowFare(String origin, String destination, LocalDate date) throws ResponseException, AirportNotFoundException, AirlineNotFoundException {

        String departureDate = date.toString();

        FlightOfferSearch[] flightOffers = amadeus.shopping.flightOffersSearch.get(Params
                .with("originLocationCode", origin)
                .and("destinationLocationCode", destination)
                .and("departureDate", departureDate)
                .and("adults", "1")
                .and("nonStop", "true")
                .and("max", "10"));

        List<FlightDto> flightDtos = new ArrayList<>();

        if (flightOffers.length == 0) {
            LOGGER.info("No flights found");
        } else {
            JsonArray jsonElements = flightOffers[0].getResponse().getResult().getAsJsonArray("data");

            for (JsonElement jsonElement : jsonElements) {
                FlightDto flightDto = new FlightDto();

                Long id = jsonElement.getAsJsonObject().get("id").getAsLong();

                BigDecimal price = jsonElement.getAsJsonObject()
                        .get("price").getAsJsonObject()
                        .get("grandTotal").getAsBigDecimal();

                String departure = jsonElement.getAsJsonObject()
                        .get("itineraries").getAsJsonArray()
                        .get(0).getAsJsonObject()
                        .get("segments").getAsJsonArray()
                        .get(0).getAsJsonObject()
                        .get("departure").getAsJsonObject()
                        .get("at").getAsString();

                String arrival = jsonElement.getAsJsonObject()
                        .get("itineraries").getAsJsonArray()
                        .get(0).getAsJsonObject()
                        .get("segments").getAsJsonArray()
                        .get(0).getAsJsonObject()
                        .get("arrival").getAsJsonObject()
                        .get("at").getAsString();

                String airlineCode = jsonElement.getAsJsonObject()
                        .get("itineraries").getAsJsonArray()
                        .get(0).getAsJsonObject()
                        .get("segments").getAsJsonArray()
                        .get(0).getAsJsonObject()
                        .get("carrierCode").getAsString();

                Timestamp arrivalTs = timeConverter.toTimestamp(arrival);
                Timestamp departureTs = timeConverter.toTimestamp(departure);

                Airport originAirport = airportService.getAirportByIATA(origin);
                Airport destinationAirport = airportService.getAirportByIATA(destination);

                Airline airline = airlineService.getAirlineByIata(airlineCode);

                flightDto.setId(id);
                flightDto.setAirport(originAirport.getName());
                flightDto.setDestination(destinationAirport.getName());
                flightDto.setPrice(price);
                flightDto.setDeparture(departureTs);
                flightDto.setArrival(arrivalTs);
                flightDto.setAirline(airline.getName());

                flightDtos.add(flightDto);
            }
        }
        return flightDtos;
    }
}
