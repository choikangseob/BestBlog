package com.ks.bestblog.service.rank;

import com.ks.bestblog.dto.response.rank.ArticleRankingResponse;
import com.ks.bestblog.enums.ArticleRankingSearchType;
import com.ks.bestblog.enums.ArticleReactionType;
import com.ks.bestblog.repository.rank.GetArticleViewsRankingMybatisRepository;
import com.ks.bestblog.repository.rank.GetCommentDescRankingMybatisRepository;
import com.ks.bestblog.repository.rank.GetReactionRankingMybatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleRankingService {

private final GetArticleViewsRankingMybatisRepository getArticleViewsRankingMybatisRepository;

private final GetReactionRankingMybatisRepository getReactionRankingMybatisRepository;

private final GetCommentDescRankingMybatisRepository getCommentDescRankingMybatisRepository;

    public List<ArticleRankingResponse> getArticleRanking(ArticleRankingSearchType searchType, ArticleReactionType reactionType) {

        List<ArticleRankingResponse> articleRankingResponses = new ArrayList<>();

        switch (searchType){

            case VIEW -> articleRankingResponses = getArticleViewsRankingMybatisRepository.getArticleRankingByViewsCount();

            case REACTION -> articleRankingResponses = getReactionRankingMybatisRepository.getArticleRankingByTypeCount(reactionType);

            case COMMENT -> articleRankingResponses = getCommentDescRankingMybatisRepository.getArticleRankingByCommentCount();

        }



        return articleRankingResponses;
    }

}
