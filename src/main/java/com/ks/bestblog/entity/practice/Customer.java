package com.ks.bestblog.entity.practice;

import com.ks.bestblog.dto.request.practice.JoinCustomerRequest;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int phonenumber;

    public Customer(String name, int phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }
    public static Customer from(JoinCustomerRequest joinCustomerRequest){
        return new Customer(joinCustomerRequest);
    }


    public Customer(JoinCustomerRequest joinCustomerRequest) {
        this.name = joinCustomerRequest.name();
        this.phonenumber = joinCustomerRequest.phonenumber();
    }
}
