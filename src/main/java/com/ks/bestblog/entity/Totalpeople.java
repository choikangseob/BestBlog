package com.ks.bestblog.entity;

import com.ks.bestblog.dto.request.JoinTotalpeopleRequest;
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
public class Totalpeople {

   @Id
   @GeneratedValue(strategy =GenerationType.IDENTITY)
   private int id;
   private int totalpeople;
   private  int price;

    public Totalpeople(int totalpeople, int price) {
        this.totalpeople = totalpeople;
        this.price = price;
    }

    public static Totalpeople from(JoinTotalpeopleRequest joinTotalPeopleRequest){
        return new Totalpeople(joinTotalPeopleRequest);
    }
    public Totalpeople(JoinTotalpeopleRequest joinTotalPeopleRequest) {
        this.totalpeople = joinTotalPeopleRequest.totalpeople();
        this.price = joinTotalPeopleRequest.price();
    }
}
