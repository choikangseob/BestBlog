package com.ks.bestblog.dto.request.article;

public record SaveArticleRequest(
        long id,

        String title,

        String content,

        long categoryId
) {
}
