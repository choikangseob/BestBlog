package com.ks.bestblog.dto.response.article;

import com.ks.bestblog.entity.Article;
import lombok.Builder;

@Builder
public record ArticleResponse(
        long id,

        String title,

        String content
) {
    public static ArticleResponse of(Article article){

        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }
}
