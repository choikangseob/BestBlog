package com.ks.bestblog.repository.rank;

import com.ks.bestblog.dto.response.articleReaction.ArticleReactionResponse;
import com.ks.bestblog.dto.response.rank.GetArticleViewsAndReactionRankingResponse;
import com.ks.bestblog.entity.ArticleReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GetReactionRankingJPARepository extends JpaRepository<ArticleReaction, Long> {


    List<ArticleReaction> findTop10ByOrderByTypeDesc();
}
