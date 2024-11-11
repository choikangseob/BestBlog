package com.ks.bestblog.repository.article;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ArticleMybatisRepository {

    List<ArticleResponse> findAllByMemberId(long memeberId);

    List<ArticleResponse> findByCreateMemberId(long CreateMemberId);
}
