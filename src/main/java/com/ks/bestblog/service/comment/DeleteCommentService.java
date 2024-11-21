package com.ks.bestblog.service.comment;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.comment.DeleteCommentRequest;
import com.ks.bestblog.dto.response.comment.DeleteCommentResponse;
import com.ks.bestblog.entity.Comment;
import com.ks.bestblog.repository.comment.DeleteCommentJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteCommentService {

    private final DeleteCommentJPARepository deleteCommentJPARepository;

    public DeleteCommentResponse deleteComment(DeleteCommentRequest deleteCommentRequest, MemberDetails member){

        Optional<Comment> commentOptional = deleteCommentJPARepository.findByIdAndCreateMemberId(deleteCommentRequest.id(), member.getId() );
        Comment comment = commentOptional.orElseThrow(()-> new RuntimeException("삭제할 값이 없습니다"));

        deleteCommentJPARepository.delete(comment);

        return DeleteCommentResponse.of(comment);
    }




}
