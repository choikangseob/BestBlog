package com.ks.bestblog.dto.response.practice;

import com.ks.bestblog.entity.practice.Phone;
import lombok.Builder;

@Builder
public record BuyPhoneResponse(
        int id,
        String model,
        int price
) {
    public static BuyPhoneResponse of(Phone savedPhone) {
        return BuyPhoneResponse.builder()
                .id(savedPhone.getId())
                .model(savedPhone.getModel())
                .price(savedPhone.getPrice())
                .build();
    }
}
