package com.kodilla.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "\"TRIPS\"")
public class Trip {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToOne
    private Flight firstFlight;
    @OneToOne
    private Flight returnFlight;
    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    private Trip(User user, Flight firstFlight, Flight returnFlight, Hotel hotel) {
        this.user = user;
        this.firstFlight = firstFlight;
        this.returnFlight = returnFlight;
        this.hotel = hotel;
    }


    public static class TripBuilder {
        private Long id;
        private User user;
        private Flight firstFlight;
        private Flight returnFlight = null;
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

        public TripBuilder returnFlight(Flight returnFlight) {
            this.returnFlight = returnFlight;
            return this;
        }

        public TripBuilder hotel(Hotel hotel) {
            this.hotel = hotel;
            return this;
        }

        public Trip build() {
            return new Trip(id, user, firstFlight, returnFlight, hotel);
        }
    }
}
