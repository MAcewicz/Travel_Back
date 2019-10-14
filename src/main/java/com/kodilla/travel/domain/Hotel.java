package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "\"HOTELS\"")
public class Hotel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal pricePerNight;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}
