package com.ks.bestblog.dto.request.rank;

public record GetArticleViewsAndReactionRankingRequest(
        long views,

        String type
) {
}
