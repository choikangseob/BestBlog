package com.ks.bestblog.dto.response;

import com.ks.bestblog.dto.request.TurnonCarRequest;
import com.ks.bestblog.entity.Car;
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
