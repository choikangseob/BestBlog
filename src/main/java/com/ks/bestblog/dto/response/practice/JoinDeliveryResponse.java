package com.ks.bestblog.dto.response.practice;

import com.ks.bestblog.entity.practice.Delivery;
import lombok.Builder;

@Builder
public record JoinDeliveryResponse(
        int id,
        String food,
        int tip
) { public static JoinDeliveryResponse of(Delivery savedDelivery ) {
    return JoinDeliveryResponse.builder()
            .id(savedDelivery.getId())
            .food(savedDelivery.getFood())
            .tip(savedDelivery.getTip())
            .build();
}
}
