package com.kodilla.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FlightDto {

    private Long id;
    private String airline;
    private String from;
    private String to;
    private LocalDateTime departure;
    private LocalDateTime arrival;
}
