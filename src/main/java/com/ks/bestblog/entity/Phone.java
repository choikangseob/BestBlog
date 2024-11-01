package com.ks.bestblog.entity;

import com.ks.bestblog.dto.request.BuyPhoneRequest;
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
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private int price;

    public Phone(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public static Phone from(BuyPhoneRequest buyPhoneRequest){
        return new Phone(buyPhoneRequest);
    }
    public Phone(BuyPhoneRequest buyPhoneRequest) {
        this.model = buyPhoneRequest.model();
        this.price = buyPhoneRequest.price();
    }
}
