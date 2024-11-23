package com.ks.bestblog.repository.rank;


import com.ks.bestblog.dto.response.rank.ArticleRankingResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetCommentDescRankingMybatisRepository {


    List<ArticleRankingResponse> getArticleRankingByCommentCount();


}
