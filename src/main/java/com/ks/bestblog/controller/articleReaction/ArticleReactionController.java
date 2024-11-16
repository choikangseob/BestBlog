package com.ks.bestblog.controller.articleReaction;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.articleReaction.ArticleReactionResponse;
import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.enums.ArticleReactionType;
import com.ks.bestblog.service.articleReaction.ArticleReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleReactionController {

    private final ArticleReactionService articleReactionService;

    @PostMapping("/saveArticleReaction/{articleId}/{type}")
    public ResponseEntity<ArticleReactionResponse> articleReaction(
            @PathVariable("articleId") long articleId,
            @PathVariable("type") ArticleReactionType type,
            @AuthenticationPrincipal MemberDetails member


            ){

        return ResponseEntity.ok(articleReactionService.articleReaction(articleId,type,member));
    }
}
