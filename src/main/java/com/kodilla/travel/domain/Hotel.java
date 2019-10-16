package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @OneToMany(targetEntity = Trip.class,
            mappedBy = "hotel",
            fetch = FetchType.LAZY)
    private List<Trip> trips = new ArrayList<>();
}
