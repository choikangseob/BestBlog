package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Category;
import lombok.Builder;

@Builder
public record CategoryResponse(
        long depth,

        long parentId,

        String title
) {

    public static CategoryResponse of(Category savedCategory) {

        return CategoryResponse.builder()
                .depth(savedCategory.getDepth())
                .parentId(savedCategory.getParentId())
                .title(savedCategory.getTitle())
                .build();
    }
}
