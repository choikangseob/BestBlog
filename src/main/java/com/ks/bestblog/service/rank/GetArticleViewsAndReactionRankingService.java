package com.ks.bestblog.service.rank;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.dto.response.articleReaction.ArticleReactionResponse;
import com.ks.bestblog.dto.response.rank.GetArticleViewsAndReactionRankingResponse;
import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.repository.rank.GetArticleViewsRankingJPARepository;
import com.ks.bestblog.repository.rank.GetReactionRankingJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticleViewsAndReactionRankingService {

private final GetArticleViewsRankingJPARepository getArticleViewsRankingJPARepository;

private final GetReactionRankingJPARepository getReactionRankingJPARepository;

    public List<GetArticleViewsAndReactionRankingResponse> articleViewsAndReactionRanking() {

        List<ArticleResponse> articleViews = getArticleViewsRankingJPARepository.findTop10ByOrderByViewsDesc();
        List<ArticleReaction> articleReactions = getReactionRankingJPARepository.findTop10ByOrderByTypeDesc();


        List<GetArticleViewsAndReactionRankingResponse> combinedRanking = new ArrayList<>();

        int maxSize = Math.min(articleViews.size(), articleReactions.size());

        for (int i = 0; i < maxSize; i++) {
            // GetArticleViewsAndReactionRankingResponse 객체로 묶어줌
            GetArticleViewsAndReactionRankingResponse response = GetArticleViewsAndReactionRankingResponse.builder()
                    .articleResponse(articleViews.get(i))  // ArticleResponse 객체
                    .articleReaction(articleReactions.get(i))  // ArticleReactionResponse 객체
                    .build();
            combinedRanking.add(response);
        }

        return combinedRanking;
    }

}
