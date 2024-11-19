package com.ks.bestblog.repository.article;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ArticleJPARepository extends JpaRepository<Article,Long> {


    List<ArticleResponse> findByCreateMemberId(long CreateMemberId);

    Optional<Article> findById(long categoryId);
}
