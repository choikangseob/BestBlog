package com.ks.bestblog.service.comment;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.comment.UpdateCommentRequest;
import com.ks.bestblog.dto.response.comment.UpdateCommentResponse;
import com.ks.bestblog.entity.Comment;
import com.ks.bestblog.repository.category.UpdateCategoryJPARepository;
import com.ks.bestblog.repository.comment.UpdateCommentJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateCommentService {

    private final UpdateCommentJPARepository updateCommentJPARepository;

    public UpdateCommentResponse updateComment(UpdateCommentRequest updateCommentRequest, MemberDetails member){

        Optional<Comment> commentOptional = updateCommentJPARepository.findByIdAndCreateMemberId(updateCommentRequest.id(), member.getId());
        Comment comment =  commentOptional.orElseThrow(()-> new RuntimeException("수정할 항목이 존재하지 않습니다"));

        comment.setArticleId(updateCommentRequest.articleId());
        comment.setDepth(updateCommentRequest.depth());
        comment.setParentId(updateCommentRequest.parentId());
        comment.setComment(updateCommentRequest.comment());

        return UpdateCommentResponse.of(comment);

    }
}
