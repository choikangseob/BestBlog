package com.ks.bestblog.repository.comment;

import com.ks.bestblog.dto.response.comment.CommentResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface GetCommentMybatisRepository{


    List<CommentResponse> findAllByArticleId(long ArticleId);
    List<CommentResponse> findByCreateMemberId(long createMemberId);
}
