package com.kodilla.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelDto {

    private Long id;
    private String name;
    private BigDecimal pricePerNight;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}
