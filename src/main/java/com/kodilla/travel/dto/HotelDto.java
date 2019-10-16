package com.kodilla.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelDto {

    private Long id;
    private String name;
    private BigDecimal pricePerNight;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private List<TripDto> tripDtos;
}
