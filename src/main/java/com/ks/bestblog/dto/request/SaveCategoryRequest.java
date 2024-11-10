package com.ks.bestblog.dto.request;

public record SaveCategoryRequest(

        long depth,

        long parentId,

        String title

) {
}
