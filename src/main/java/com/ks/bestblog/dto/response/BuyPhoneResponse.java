package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Phone;
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
