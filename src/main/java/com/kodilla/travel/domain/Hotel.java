package com.kodilla.travel.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"HOTELS\"")
public class Hotel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String city;
    private BigDecimal pricePerNight;
    private Timestamp checkIn;
    private Timestamp checkOut;
}
