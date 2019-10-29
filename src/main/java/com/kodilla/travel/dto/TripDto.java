package com.kodilla.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TripDto {

    private Long id;
    private Long userId;
    private Long firstFlightId;
    private Long returnFlightId;
    private Long hotelId;

    public static class TripDtoBuilder {
        private Long id;
        private Long userId;
        private Long firstFlightId;
        private Long returnFlightId = null;
        private Long hotelId = null;

        public TripDtoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public TripDtoBuilder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public TripDtoBuilder firstFlight(Long firstFlightId) {
            this.firstFlightId = firstFlightId;
            return this;
        }

        public TripDtoBuilder returnFlight(Long returnFlightId) {
            this.returnFlightId = returnFlightId;
            return this;
        }

        public TripDtoBuilder hotel(Long hotelId) {
            this.hotelId = hotelId;
            return this;
        }

        public TripDto build() {
            return new TripDto(id, userId, firstFlightId, returnFlightId, hotelId);
        }
    }





}
