package com.ks.bestblog.dto.response.article;

import com.ks.bestblog.entity.Article;
import lombok.Builder;

@Builder
public record ArticleResponse(
        long id,

        String title,

        String content,

        String isPublic,

        long views

) {
    public static ArticleResponse of(Article article){

        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .isPublic(article.getIsPublic())
                .views(article.getViews())
                .build();
    }
}
