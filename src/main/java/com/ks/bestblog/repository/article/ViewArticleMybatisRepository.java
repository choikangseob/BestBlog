package com.ks.bestblog.repository.article;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViewArticleMybatisRepository {

    List<ArticleResponse> findByIdAndTitle(long articleId);
}
