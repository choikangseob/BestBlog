package com.ks.bestblog.entity;

import com.ks.bestblog.dto.request.TurnonCarRequest;
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
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;

    private String engine;

    public Car(String model, String engine) {
        this.model = model;
        this.engine = engine;
    }
    public static Car from(TurnonCarRequest turnonCarRequest) {
        return new Car(turnonCarRequest);
    }
    public Car(TurnonCarRequest turnonCarRequest){
        this.model = turnonCarRequest.model();
        this.engine = turnonCarRequest.engine();
    }
}
