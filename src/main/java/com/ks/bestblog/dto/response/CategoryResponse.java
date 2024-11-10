package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Category;
import lombok.Builder;

@Builder
public record CategoryResponse(
        long id,

        long depth,

        long parentId,

        String title
) {

    public static CategoryResponse of(Category category) {

        return CategoryResponse.builder()
                .id(category.getId())
                .depth(category.getDepth())
                .parentId(category.getParentId())
                .title(category.getTitle())
                .build();
    }
}
