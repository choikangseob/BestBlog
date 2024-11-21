package com.ks.bestblog.repository.comment;

import com.ks.bestblog.dto.response.comment.CommentResponse;
import com.ks.bestblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GetCommentJPARepository extends JpaRepository<Comment, Long> {

    List<CommentResponse> findByCreateMemberId(long id);

    List<CommentResponse> findTop10ByOrderByCommentDesc();

    List<CommentResponse> findTop10ByOrderByCommentAsc();
}
