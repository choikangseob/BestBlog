package com.ks.bestblog.dto.request;

public record UpdateCategoryRequest(
        long id,

        long depth,

        String title
) {
}
