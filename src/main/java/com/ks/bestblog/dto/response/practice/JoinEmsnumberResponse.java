package com.ks.bestblog.dto.response.practice;

import com.ks.bestblog.entity.practice.Emsnumber;
import lombok.Builder;

@Builder
public record JoinEmsnumberResponse(
        int id,
        String department,
        int number
) {
    public static JoinEmsnumberResponse of(Emsnumber emsnumber) {
        return JoinEmsnumberResponse.builder()
                .id(emsnumber.getId())
                .department(emsnumber.getDepartment())
                .number(emsnumber.getNumber())
                .build();
    }
}
