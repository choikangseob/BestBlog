package com.ks.bestblog.dto.request;

public record DeleteCategoryRequest(
        long id,

        long depth,

        String title
) {
}
