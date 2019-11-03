package com.kodilla.travel.controller;

import com.kodilla.travel.dto.AirportDto;
import com.kodilla.travel.exception.AirportNotFoundException;
import com.kodilla.travel.mappers.AirportMapper;
import com.kodilla.travel.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/travel/")
@CrossOrigin("*")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportMapper airportMapper;

    @GetMapping(value = "airport")
    public List<AirportDto> getAirports() {
        return airportMapper.mapToAirportDtoList(airportService.getAllAirports());
    }

    @GetMapping(value = "airport/country/{countryCode}")
    public List<AirportDto> getAirportsByCountryCode(@PathVariable String countryCode) {
        return airportMapper.mapToAirportDtoList(airportService.getAirportsByCountryCode(countryCode));
    }

    @GetMapping(value = "airport/city/{city}")
    public List<AirportDto> getAirportsByCity(@PathVariable String city) {
        return airportMapper.mapToAirportDtoList(airportService.getAirportsByCity(city));
    }

    @GetMapping(value = "airport/{id}")
    public AirportDto getAirportById(@PathVariable Long id) throws AirportNotFoundException {
        return airportMapper.mapToAirportDto(airportService.getAirportById(id).orElseThrow(AirportNotFoundException::new));
    }

    @GetMapping(value = "airport/iata/{iata}")
    public AirportDto getAirportByIata(@PathVariable String iata) throws AirportNotFoundException {
        return airportMapper.mapToAirportDto(airportService.getAirportByIATA(iata).orElseThrow(AirportNotFoundException::new));
    }

    @PutMapping(value = "airport")
    public AirportDto updateAirport(@RequestBody AirportDto airportDto) {
        return airportMapper.mapToAirportDto(airportService.saveAirport(airportMapper.mapToAirport(airportDto)));
    }

    @PostMapping(value = "airport")
    public void saveAirport(@RequestBody AirportDto airportDto) {
        airportService.saveAirport(airportMapper.mapToAirport(airportDto));
    }

    @DeleteMapping(value = "airport")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteById(id);
    }

}
