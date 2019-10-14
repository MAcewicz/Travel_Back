package com.kodilla.travel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Weather Not Found!")
public class WeatherNotFoundException extends Exception {
}
