package com.kodilla.travel.exception;

public class WeatherNotFoundException extends RuntimeException {

    public WeatherNotFoundException() {
        super("Weather for given location or date not found.");
    }
}
