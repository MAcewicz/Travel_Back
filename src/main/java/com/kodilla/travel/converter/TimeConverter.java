package com.kodilla.travel.converter;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeConverter {

    public Timestamp toTimestamp(String time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        String string = ldt.format(dtf);
        return Timestamp.valueOf(string);
    }
}
