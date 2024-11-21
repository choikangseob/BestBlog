package com.ks.bestblog.controller.comment;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.comment.CommentResponse;
import com.ks.bestblog.service.comment.GetCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetCommentController {

    private final GetCommentService getCommentService;

    @GetMapping("/comments/{articleId}")
    public ResponseEntity<List<CommentResponse>> getComments(
            @PathVariable("articleId") long id ) {

        return ResponseEntity.ok(getCommentService.getCommentAllById(id));
    }

    @GetMapping("/comment/{memberId}")
    public ResponseEntity<List<CommentResponse>> getComment(
            @AuthenticationPrincipal MemberDetails member
            ){
        return ResponseEntity.ok(getCommentService.getCommentByCreateMemberId(member));
    }
}
