package com.ks.bestblog.controller.likeunlike;


import com.ks.bestblog.dto.request.likeunlike.SaveLikesDislikeRequest;
import com.ks.bestblog.dto.response.likeunlike.LikesDislikeResponse;
import com.ks.bestblog.service.likeunlike.AlertLikeDislikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlertLikesDislikeController {

    private final AlertLikeDislikeService alertLikeDislikeService;

    @PostMapping("/noLoginlikesDislike")
    public ResponseEntity<LikesDislikeResponse> saveLikeUnlike(

            @RequestBody SaveLikesDislikeRequest saveLikesDislikeRequest
    ){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(alertLikeDislikeService.saveLike(saveLikesDislikeRequest,authentication));
    }
}
