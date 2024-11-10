package com.ks.bestblog.dto.request;

public record SaveCategoryRequest(

        long id,

        long depth,

        long parentId,

        String title

) {
}
