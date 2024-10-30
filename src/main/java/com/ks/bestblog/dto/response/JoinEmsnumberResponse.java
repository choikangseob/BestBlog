package com.ks.bestblog.dto.response;

import com.ks.bestblog.dto.request.JoinEmsnumberRequest;
import com.ks.bestblog.entity.Emsnumber;
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
