package com.ks.bestblog.dto.response.rank;


import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.entity.Comment;
import lombok.Builder;


@Builder
public record GetArticleViewsAndReactionRankingResponse(
        ArticleResponse articleResponse,
        ArticleReaction articleReaction,
        Comment comment
) {

}
