package com.ks.bestblog.controller.rank;


import com.ks.bestblog.dto.response.rank.ArticleRankingResponse;
import com.ks.bestblog.enums.ArticleRankingSearchType;
import com.ks.bestblog.enums.ArticleReactionType;
import com.ks.bestblog.service.rank.ArticleRankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleRankingController {

    private final ArticleRankingService articleRankingService;

    @GetMapping("/articleRanking")
    public ResponseEntity<List<ArticleRankingResponse>> articleRanking(
            @RequestParam ArticleRankingSearchType searchType,
            @RequestParam(required = false) ArticleReactionType reactionType
    ) {
        List<ArticleRankingResponse> rankingResponse = articleRankingService.getArticleRanking(searchType,reactionType);

        return ResponseEntity.ok(rankingResponse);
    }

}
