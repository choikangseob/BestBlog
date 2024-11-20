package com.ks.bestblog.dto.response.rank;


import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.ArticleReaction;
import lombok.Builder;


@Builder
public record GetArticleViewsAndReactionRankingResponse(
        ArticleResponse articleResponse,
        ArticleReaction articleReaction) {

}
