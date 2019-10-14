package com.kodilla.travel.dto;

import com.kodilla.travel.domain.Flight;
import com.kodilla.travel.domain.Weather;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TripDto {

    private Long id;
    private Long userId;
    private FlightDto firstFlight;
    private FlightDto returnFlight;
    private WeatherDto weather;
    private HotelDto hotel;

    public static class TripDtoBuilder {
        private Long id;
        private Long userId;
        private FlightDto firstFlight;
        private FlightDto returnFlight = null;
        private WeatherDto weather;
        private HotelDto hotel = null;

        public TripDtoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public TripDtoBuilder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public TripDtoBuilder firstFlight(FlightDto firstFlight) {
            this.firstFlight = firstFlight;
            return this;
        }

        public TripDtoBuilder returnFlight(FlightDto returnFlight) {
            this.returnFlight = returnFlight;
            return this;
        }

        public TripDtoBuilder weather(WeatherDto weather) {
            this.weather = weather;
            return this;
        }
        public TripDtoBuilder hotel(HotelDto hotel) {
            this.hotel = hotel;
            return this;
        }

        public TripDto build() {
            return new TripDto(id, userId, firstFlight, returnFlight, weather, hotel);
        }
    }





}
