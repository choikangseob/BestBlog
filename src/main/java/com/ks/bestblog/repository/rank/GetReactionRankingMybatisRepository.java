package com.ks.bestblog.repository.rank;

import com.ks.bestblog.dto.response.rank.ArticleRankingResponse;
import com.ks.bestblog.enums.ArticleReactionType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetReactionRankingMybatisRepository {


    List<ArticleRankingResponse> getArticleRankingByTypeCount(ArticleReactionType reactionType);
}
