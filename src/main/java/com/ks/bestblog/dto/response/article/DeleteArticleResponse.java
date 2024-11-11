package com.ks.bestblog.dto.response.article;

import com.ks.bestblog.entity.Article;
import lombok.Builder;

@Builder
public record DeleteArticleResponse(
        long id
) {

    public static DeleteArticleResponse of(Article deleteArticle) {

        return DeleteArticleResponse.builder()
                .id(deleteArticle.getId())
                .build();
    }
}
