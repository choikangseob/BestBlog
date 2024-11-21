package com.ks.bestblog.service.comment;

import com.ks.bestblog.dto.request.comment.SaveCommentRequest;
import com.ks.bestblog.dto.response.comment.CommentResponse;
import com.ks.bestblog.entity.Comment;
import com.ks.bestblog.repository.comment.SaveCommentJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCommentService {

    private final SaveCommentJPARepository saveCommentJPARepository;

    public CommentResponse saveComment(SaveCommentRequest saveCommentRequest){

        Comment saveComment = Comment.from(saveCommentRequest);
        Comment savedComment = saveCommentJPARepository.save(saveComment);

        return CommentResponse.of(savedComment);
    }
}
