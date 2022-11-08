package com.kodilla.travel.exception;

public class AirportNotFoundException extends RuntimeException {

    public AirportNotFoundException() {
        super("No such airport found.");
    }
}
