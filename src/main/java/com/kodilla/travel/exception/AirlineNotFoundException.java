package com.kodilla.travel.exception;

public class AirlineNotFoundException extends RuntimeException {

    public AirlineNotFoundException() {
        super("No airline found.");
    }
}
