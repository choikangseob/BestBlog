package com.ks.bestblog.controller.comment;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.comment.UpdateCommentRequest;
import com.ks.bestblog.dto.response.comment.UpdateCommentResponse;
import com.ks.bestblog.repository.member.MemberJPARepository;
import com.ks.bestblog.service.comment.UpdateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateCommentController {

    private final UpdateCommentService updateCommentService;
    private final MemberJPARepository memberJPARepository;


    @PostMapping("/updateComment")
    public ResponseEntity<UpdateCommentResponse> updateComment(
            @RequestBody UpdateCommentRequest updateCommentRequest,
            @AuthenticationPrincipal MemberDetails member

    ){

        return ResponseEntity.ok(updateCommentService.updateComment(updateCommentRequest,member));
    }

}
