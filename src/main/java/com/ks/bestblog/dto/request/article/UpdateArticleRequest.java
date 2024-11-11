package com.ks.bestblog.dto.request.article;

public record UpdateArticleRequest(
        long id,

        String title,

        String content,

        long categoryId
) {
}
