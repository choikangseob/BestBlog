package com.ks.bestblog.dto.response.practice;

import com.ks.bestblog.entity.practice.Car;
import lombok.Builder;

@Builder
public record TurnonResponse(
        int id,
        String model,
        String engine
) {
    public static TurnonResponse of(Car savedCar){
        return TurnonResponse.builder()
                .id(savedCar.getId())
                .model(savedCar.getModel())
                .engine(savedCar.getEngine())
                .build();
    }

}
