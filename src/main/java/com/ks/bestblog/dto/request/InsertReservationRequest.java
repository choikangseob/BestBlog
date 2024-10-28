package com.ks.bestblog.dto.request;

public record InsertReservationRequest(
        String roomname,
        int price
) {
}
