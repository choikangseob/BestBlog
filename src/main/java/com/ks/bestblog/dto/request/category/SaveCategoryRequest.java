package com.ks.bestblog.dto.request.category;


public record SaveCategoryRequest(

        long id,

        long depth,

        long parentId,

        String title

) {
}
