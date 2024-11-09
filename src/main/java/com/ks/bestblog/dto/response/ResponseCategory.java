package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Category;
import lombok.Builder;

@Builder
public record ResponseCategory(
        long depth,

        String title
) {

    public static ResponseCategory of(Category savedCategory) {

        return ResponseCategory.builder()
                .depth(savedCategory.getDepth())
                .title(savedCategory.getTitle())
                .build();
    }
}
