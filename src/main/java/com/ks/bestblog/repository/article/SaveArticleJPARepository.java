package com.ks.bestblog.repository.article;

import com.ks.bestblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveArticleJPARepository extends JpaRepository<Article, Long> {

}
