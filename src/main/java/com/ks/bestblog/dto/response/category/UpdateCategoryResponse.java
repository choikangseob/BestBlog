package com.ks.bestblog.dto.response.category;

import com.ks.bestblog.entity.Category;
import lombok.Builder;

@Builder
public record UpdateCategoryResponse(
        long id,

        long depth,

        String title
) {

    public static UpdateCategoryResponse of(Category savedCategory) {

        return UpdateCategoryResponse.builder()
                .id(savedCategory.getId())
                .depth(savedCategory.getDepth())
                .title(savedCategory.getTitle())
                .build();
    }
}
