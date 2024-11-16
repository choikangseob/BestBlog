package com.ks.bestblog.repository.articleReaction;

import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.enums.ArticleReactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleReactionJPARepository extends JpaRepository<ArticleReaction, Long> {


    Optional<ArticleReaction> findByArticleIdAndTypeAndCreateMemberId(long articleId, ArticleReactionType type, long createMemberId);

    Optional<ArticleReaction> findAllArticleId(long articleId);
}
