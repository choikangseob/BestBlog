package com.ks.bestblog.controller.likeunlike;


import com.ks.bestblog.dto.request.likeunlike.SaveLikesDislikeRequest;
import com.ks.bestblog.dto.response.likeunlike.LikesDislikeResponse;
import com.ks.bestblog.service.likeunlike.SaveLikesDislikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SaveLikesDislikeController {

    private final SaveLikesDislikeService saveLikesDislikeService;

    @PostMapping("/saveLikesDislikeAction")
    public ResponseEntity<LikesDislikeResponse> saveLikesDislike(
            @RequestBody SaveLikesDislikeRequest saveLikesDislikeRequest,
            @RequestParam SaveLikesDislikeService.SelectType selectType
            ){

        return ResponseEntity.ok(saveLikesDislikeService.saveLikesDislike(saveLikesDislikeRequest,selectType));
    }
}
