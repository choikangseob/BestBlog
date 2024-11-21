package com.ks.bestblog.repository.comment;

import com.ks.bestblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UpdateCommentJPARepository extends JpaRepository<Comment, Long> {


    Optional<Comment> findByIdAndCreateMemberId(long id, long CreateMemberId);
}
