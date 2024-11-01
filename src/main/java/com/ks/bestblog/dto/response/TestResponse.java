package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Test;
import lombok.Builder;

@Builder
public record TestResponse(
        int id,
        String realname,
        int number
) {
    public static TestResponse of(Test savedTest) {
        return TestResponse.builder()
                .id(savedTest.getId())
                .realname(savedTest.getRealname())
                .number(savedTest.getNumber())
                .build();
    }
}
