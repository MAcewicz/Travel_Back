package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "\"FLIGHTS\"")
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private String airline;
    private String from;
    private String to;
    private LocalDateTime departure;
    private LocalDateTime arrival;
}
