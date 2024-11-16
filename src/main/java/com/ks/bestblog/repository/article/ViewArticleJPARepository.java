package com.ks.bestblog.repository.article;

import com.ks.bestblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ViewArticleJPARepository extends JpaRepository<Article, Long> {

    Optional<Article> findById(long articleId);
}
