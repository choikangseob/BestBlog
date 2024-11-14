package com.ks.bestblog.controller.likeunlike;


import com.ks.bestblog.dto.request.likeunlike.SaveLikeRequest;
import com.ks.bestblog.dto.response.likeunlike.LikeResponse;
import com.ks.bestblog.service.likeunlike.SaveLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SaveLikeController {

    private final SaveLikeService saveLikeService;

    @PostMapping("/like")
    public ResponseEntity<LikeResponse> saveLikeUnlike(

            @RequestBody SaveLikeRequest saveLikeRequest
    ){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(saveLikeService.saveLike(saveLikeRequest,authentication));
    }
}
