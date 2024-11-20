package com.ks.bestblog.repository.rank;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GetArticleViewsRankingJPARepository extends JpaRepository<Article, Long> {


    List<ArticleResponse> findTop10ByOrderByViewsDesc();
}
