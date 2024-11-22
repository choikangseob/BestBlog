package com.ks.bestblog.repository.rank;

import com.ks.bestblog.entity.ArticleReaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GetReactionRankingMybatisRepository extends JpaRepository<ArticleReaction, Long> {


    List<ArticleReaction> findTop10ByOrderByTypeDesc();
}
