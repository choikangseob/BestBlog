package com.ks.bestblog.dto.response.article;

import com.ks.bestblog.entity.Article;
import lombok.Builder;

@Builder
public record ArticleResponse(
        long id,

        String title,

        String content
) {
    public static ArticleResponse of(Article savedArticle){

        return ArticleResponse.builder()
                .id(savedArticle.getId())
                .title(savedArticle.getTitle())
                .content(savedArticle.getContent())
                .build();
    }
}
