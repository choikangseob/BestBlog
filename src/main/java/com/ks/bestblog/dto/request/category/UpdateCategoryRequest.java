package com.ks.bestblog.dto.request.category;

public record UpdateCategoryRequest(
        long id,

        long depth,

        String title
) {
}
