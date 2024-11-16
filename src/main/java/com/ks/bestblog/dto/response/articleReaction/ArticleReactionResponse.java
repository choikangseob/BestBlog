package com.ks.bestblog.dto.response.articleReaction;


import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.enums.ArticleReactionType;
import lombok.Builder;

@Builder
public record ArticleReactionResponse(
        long id,

        long articleId,

        long createMemberId,

        ArticleReactionType type,

        String processedResultType
) {

    public static ArticleReactionResponse of(ArticleReaction savedAction, String processedResultType) {

        return ArticleReactionResponse.builder()
                .id(savedAction.getId())
                .articleId(savedAction.getArticleId())
                .createMemberId(savedAction.getCreateMemberId())
                .type(savedAction.getType())
                .processedResultType(processedResultType)
                .build();

    }
}
