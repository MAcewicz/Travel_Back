package com.kodilla.travel.converter;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeConverter {

    public Timestamp toTimestamp(String time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(time, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        String string = ldt.format(dtf);
        return Timestamp.valueOf(string);
    }

    public LocalDateTime toLocalDateTime(Timestamp ts) {
        return ts.toLocalDateTime();
    }
}
