package com.ks.bestblog.controller.comment;

import com.ks.bestblog.dto.request.comment.SaveCommentRequest;
import com.ks.bestblog.dto.response.comment.CommentResponse;
import com.ks.bestblog.service.comment.SaveCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SaveCommentController {

    private final SaveCommentService saveCommentService;

    @PostMapping("/saveComment")
    public ResponseEntity<CommentResponse> saveComment(
            @RequestBody SaveCommentRequest saveCommentRequest
            ){

        return ResponseEntity.ok(saveCommentService.saveComment(saveCommentRequest));
    }
}
