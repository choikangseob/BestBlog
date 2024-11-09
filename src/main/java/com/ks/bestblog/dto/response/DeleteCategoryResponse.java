package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Category;
import lombok.Builder;

@Builder
public record DeleteCategoryResponse(
        long id
) {

    public static DeleteCategoryResponse of(Category categoryDelete) {

        return DeleteCategoryResponse.builder()
                .id(categoryDelete.getId())
                .build();
    }
}
