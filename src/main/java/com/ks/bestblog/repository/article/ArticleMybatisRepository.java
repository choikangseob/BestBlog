package com.ks.bestblog.repository.article;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMybatisRepository {

    List<ArticleResponse> findAllByMemberId(long memeberId);

    List<ArticleResponse> findByCreateMemberId(long CreateMemberId);
}
