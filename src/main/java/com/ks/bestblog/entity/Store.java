package com.ks.bestblog.entity;


import com.ks.bestblog.dto.request.JoinStoreRequest;
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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int id;

            private String goodsname;

            private int price;

    public Store(int price, String goodsname) {
        this.price = price;
        this.goodsname = goodsname;
    }
    public static Store from(JoinStoreRequest joinStoreRequest) {
        return new Store(joinStoreRequest);
    }

    public Store(JoinStoreRequest joinStoreRequest) {

        this.goodsname = joinStoreRequest.goodsname();
        this.price = joinStoreRequest.price();
    }
}
