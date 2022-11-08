package com.kodilla.travel.exception;

public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException() {
        super("Flight not found.");
    }
}
