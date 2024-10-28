package com.ks.bestblog.entity;

import com.ks.bestblog.dto.request.InsertMenuRequest;
import com.ks.bestblog.dto.request.InsertReservationRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String roomname;

    private int price;

    public Reservation(String roomname, int price) {
        this.roomname = roomname;
        this.price = price;
    }

    public static Reservation from(InsertReservationRequest insertReservationRequest){
        return new Reservation(insertReservationRequest);
    }

    public Reservation(InsertReservationRequest insertReservationRequest) {
        this.roomname = insertReservationRequest.roomname();
        this.price = insertReservationRequest.price();
    }
}

