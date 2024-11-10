package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Category;
import lombok.Builder;

@Builder
public record CategoryResponse(
        long depth,

        String title
) {

    public static CategoryResponse of(Category savedCategory) {

        return CategoryResponse.builder()
                .depth(savedCategory.getDepth())
                .title(savedCategory.getTitle())
                .build();
    }
}
