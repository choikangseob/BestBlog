package com.ks.bestblog.controller.rank;


import com.ks.bestblog.dto.response.rank.GetArticleViewsAndReactionRankingResponse;
import com.ks.bestblog.service.rank.GetArticleViewsAndReactionRankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetArticleViewsAndReactionRankingController {

    private final GetArticleViewsAndReactionRankingService getArticleViewsAndReactionRankingService;

    @GetMapping("/viewsAndReactionRanking")
    public ResponseEntity<List<GetArticleViewsAndReactionRankingResponse>> viewsAndReactionRanking() {
        List<GetArticleViewsAndReactionRankingResponse> rankingResponse = getArticleViewsAndReactionRankingService.articleViewsAndReactionRanking();

        return ResponseEntity.ok(rankingResponse);
    }

}
