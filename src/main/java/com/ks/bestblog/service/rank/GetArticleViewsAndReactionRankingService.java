package com.ks.bestblog.service.rank;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.dto.response.rank.GetArticleViewsAndReactionRankingResponse;
import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.entity.Comment;
import com.ks.bestblog.repository.rank.GetArticleViewsRankingJPARepository;
import com.ks.bestblog.repository.rank.GetCommentDescAscRankingMybatisRepository;
import com.ks.bestblog.repository.rank.GetReactionRankingMybatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticleViewsAndReactionRankingService {

private final GetArticleViewsRankingJPARepository getArticleViewsRankingJPARepository;

private final GetReactionRankingMybatisRepository getReactionRankingMybatisRepository;

private final GetCommentDescAscRankingMybatisRepository getCommentDescAscRankingMybatisRepository;

    public List<GetArticleViewsAndReactionRankingResponse> articleViewsAndReactionRanking() {

        List<ArticleResponse> articleViews = getArticleViewsRankingJPARepository.findTop10ByOrderByViewsDesc();
        List<ArticleReaction> articleReactions = getReactionRankingMybatisRepository.findTop10ByOrderByTypeDesc();
        List<Comment> commentDesc = getCommentDescAscRankingMybatisRepository.findTop10ByOrderByCommentDesc();
        List<Comment> commentAsc = getCommentDescAscRankingMybatisRepository.findTop10ByOrderByCommentAsc();


        List<GetArticleViewsAndReactionRankingResponse> combinedRanking = new ArrayList<>();

        int maxSize = Math.min(
                Math.min(articleViews.size(), articleReactions.size()),
                Math.min(commentDesc.size(), commentAsc.size())
        );

        for (int i = 0; i < maxSize; i++) {
            // GetArticleViewsAndReactionRankingResponse 객체로 묶어줌
            GetArticleViewsAndReactionRankingResponse response = GetArticleViewsAndReactionRankingResponse.builder()
                    .articleResponse(articleViews.get(i))  // ArticleResponse 객체
                    .articleReaction(articleReactions.get(i))  // ArticleReactionResponse 객체
                    .comment(commentDesc.get(i))
                    .comment(commentAsc.get(i))
                    .build();
            combinedRanking.add(response);
        }

        return combinedRanking;
    }

}
