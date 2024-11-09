package com.ks.bestblog.entity.practice;


import com.ks.bestblog.dto.request.practice.JoinDeliveryRequest;
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
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String food;
    private int tip;

    public Delivery(String food, int tip) {
        this.food = food;
        this.tip = tip;
    }
    public static Delivery from(JoinDeliveryRequest joinDeliveryRequest) {
        return new Delivery(joinDeliveryRequest);
    }

    public Delivery(JoinDeliveryRequest joinDeliveryRequest) {
        this.food = joinDeliveryRequest.food();
        this.tip = joinDeliveryRequest.tip();

    }
}
