package com.ks.bestblog.controller.likeunlike;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.likeunlike.DeleteLikesDislikeRequest;
import com.ks.bestblog.dto.response.likeunlike.DeleteLikesDislikeResponse;
import com.ks.bestblog.service.likeunlike.DeleteLikesDislikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteLikesDislikeController {

    private final DeleteLikesDislikeService deleteLikesDislikeService;

    @PostMapping("/deleteLikesDislikeAction")
    public ResponseEntity<DeleteLikesDislikeResponse> deleteLikesDislike(

            @RequestBody DeleteLikesDislikeRequest deleteLikesDislikeRequest,
            @AuthenticationPrincipal MemberDetails member,
            @RequestParam DeleteLikesDislikeService.SelectType selectType

    ){

        return ResponseEntity.ok(deleteLikesDislikeService.deleteLikesDislike(deleteLikesDislikeRequest,member,selectType));
    }
}
