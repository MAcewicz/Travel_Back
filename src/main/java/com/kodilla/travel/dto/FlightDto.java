package com.kodilla.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDto {

    private Long id;
    private String airline;
    private String airport;
    private String destination;
    private Timestamp departure;
    private Timestamp arrival;
    private BigDecimal price;

}
