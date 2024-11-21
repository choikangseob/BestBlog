package com.ks.bestblog.controller.comment;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.comment.DeleteCommentRequest;
import com.ks.bestblog.dto.response.comment.DeleteCommentResponse;
import com.ks.bestblog.service.comment.DeleteCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteCommentController {

    private final DeleteCommentService deleteCommentService;

    @PostMapping("/deleteCommnet")
    public ResponseEntity<DeleteCommentResponse> deleteComment(
            @RequestBody DeleteCommentRequest deleteCommentRequest,

            @AuthenticationPrincipal MemberDetails member
    ){
        return ResponseEntity.ok(deleteCommentService.deleteComment(deleteCommentRequest,member));
    }
}
