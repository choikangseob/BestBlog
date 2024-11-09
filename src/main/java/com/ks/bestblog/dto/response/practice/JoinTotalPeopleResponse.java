package com.ks.bestblog.dto.response.practice;

import com.ks.bestblog.entity.practice.Totalpeople;
import lombok.Builder;

@Builder
public record JoinTotalPeopleResponse(
        int id,
        int totalpeople,
        int price
) {
    public static JoinTotalPeopleResponse of(Totalpeople savedTotalpeople) {
        return JoinTotalPeopleResponse.builder()
                .id(savedTotalpeople.getId())
                .totalpeople(savedTotalpeople.getTotalpeople())
                .price(savedTotalpeople.getPrice())
                .build();
    }
}
