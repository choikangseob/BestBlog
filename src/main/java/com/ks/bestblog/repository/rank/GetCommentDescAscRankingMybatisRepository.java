package com.ks.bestblog.repository.rank;


import com.ks.bestblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetCommentDescAscRankingMybatisRepository {


    List<Comment> findTop10ByOrderByCommentDesc();

    List<Comment> findTop10ByOrderByCommentAsc();
}
