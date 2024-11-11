package com.ks.bestblog.dto.response.article;

import com.ks.bestblog.entity.Article;
import lombok.Builder;

@Builder
public record UpdateArticleResponse(
        long id,

        String title,

        String content
) {
    public static UpdateArticleResponse of(Article UpdateAritcle){

        return UpdateArticleResponse.builder()
                .id(UpdateAritcle.getId())
                .title(UpdateAritcle.getTitle())
                .content(UpdateAritcle.getContent())
                .build();
    }
}
