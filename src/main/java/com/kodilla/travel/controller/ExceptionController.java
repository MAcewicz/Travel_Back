package com.kodilla.travel.controller;

import com.kodilla.travel.exception.AirlineNotFoundException;
import com.kodilla.travel.exception.AirportNotFoundException;
import com.kodilla.travel.exception.FlightNotFoundException;
import com.kodilla.travel.exception.WeatherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AirlineNotFoundException.class)
    public ResponseEntity<String> handleAirlineNotFound(AirlineNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(AirportNotFoundException.class)
    public ResponseEntity<String> handleAirlineNotFound(AirportNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<String> handleAirlineNotFound(FlightNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(WeatherNotFoundException.class)
    public ResponseEntity<String> handleAirlineNotFound(WeatherNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
