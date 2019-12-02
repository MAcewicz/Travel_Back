package com.kodilla.travel.domain;

import com.kodilla.travel.converter.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Weather.clearData",
                query = "DELETE FROM weather WHERE date < CURRENT_DATE"
        ),
        @NamedNativeQuery(
                name = "Weather.getGoodConditions",
                query = "SELECT * FROM weather WHERE temperature >= :TEMP AND cloudiness <= :CLOUDS AND rainfall <= :RAIN",
                resultClass = Weather.class
        )
})

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"WEATHER\"")
public class Weather implements Comparable {

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;
    private int temperature;
    private int cloudiness;
    private int rainfall;

    public Weather(String city, LocalDate date, int temperature, int cloudiness, int rainfall) {
        this.city = city;
        this.date = date;
        this.temperature = temperature;
        this.cloudiness = cloudiness;
        this.rainfall = rainfall;
    }

    @Override
    public int compareTo(Object o) {
        int compareTemp = ((Weather)o).getTemperature();
        return compareTemp - this.getTemperature();
    }
}
