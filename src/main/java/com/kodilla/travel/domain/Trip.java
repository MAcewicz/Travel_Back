package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "\"TRIPS\"")
public class Trip {

    @Id
    @GeneratedValue
    private Long id;
    private User user;
    private Flight firstFlight;
    private Flight returnFlight;
    private Weather weather;
    private Hotel hotel;

    private Trip(User user, Flight firstFlight, Flight returnFlight, Weather weather, Hotel hotel) {
        this.user = user;
        this.firstFlight = firstFlight;
        this.returnFlight = returnFlight;
        this.weather = weather;
        this.hotel = hotel;
    }


    public static class TripBuilder {
        private Long id;
        private User user;
        private Flight firstFlight;
        private Flight returnFlight = null;
        private Weather weather;
        private Hotel hotel = null;

        public TripBuilder id(long id) {
            this.id = id;
            return this;
        }

        public TripBuilder user(User user) {
            this.user = user;
            return this;
        }

        public TripBuilder firstFlight(Flight firstFlight) {
            this.firstFlight = firstFlight;
            return this;
        }

        public TripBuilder weather (Weather weather) {
            this.weather= weather;
            return this;
        }

        public TripBuilder returnFlight(Flight returnFlight) {
            this.returnFlight = returnFlight;
            return this;
        }

        public TripBuilder hotel(Hotel hotel) {
            this.hotel = hotel;
            return this;
        }

        public Trip build() {
            return new Trip(id, user, firstFlight, returnFlight, weather, hotel);
        }
    }
}
