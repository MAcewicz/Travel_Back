package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "\"FLIGHTS\"")
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private String airline;
    private String airport;
    private String destination;
    private Timestamp departure;
    private Timestamp arrival;
    private BigDecimal price;

}
