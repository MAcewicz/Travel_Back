package com.kodilla.travel.controller;

import com.kodilla.travel.dto.AirlineDto;
import com.kodilla.travel.mappers.AirlineMapper;
import com.kodilla.travel.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/travel/")
@CrossOrigin("*")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirlineMapper airlineMapper;

    @PutMapping(value = "airline")
    public AirlineDto updateAirline(@RequestBody AirlineDto airlineDto) {
        return airlineMapper.mapToAirlineDto(airlineService.saveAirline(airlineMapper.mapToAirline(airlineDto)));
    }

    @PostMapping(value = "airline")
    public void saveAirline(@RequestBody AirlineDto airlineDto) {
        airlineService.saveAirline(airlineMapper.mapToAirline(airlineDto));
    }

    @DeleteMapping(value = "airline/{id}")
    public void deleteAirline(@PathVariable Long id) {
        airlineService.deleteAirline(id);
    }
}
