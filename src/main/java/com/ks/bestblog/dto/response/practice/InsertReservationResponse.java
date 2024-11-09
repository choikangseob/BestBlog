package com.ks.bestblog.dto.response.practice;

import com.ks.bestblog.entity.practice.Reservation;
import lombok.Builder;

@Builder
public record InsertReservationResponse(
        int id,
        String roomname,
        int price
) {
    public static InsertReservationResponse of(Reservation savedReservation) {
        return InsertReservationResponse.builder()
                .id(savedReservation.getId())
                .roomname(savedReservation.getRoomname())
                .price(savedReservation.getPrice())
                .build();
    }
}
