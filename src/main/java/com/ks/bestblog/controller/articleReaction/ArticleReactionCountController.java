package com.ks.bestblog.controller.articleReaction;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.articleReaction.ArticleReactionResponse;
import com.ks.bestblog.dto.response.articleReaction.ArticleReactionsActiveResponse;
import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.service.articleReaction.ArticleReactionCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleReactionCountController {

    private final ArticleReactionCountService articleReactionCountService;


    @GetMapping("/articleReactionCount/{articleId}")
    public ResponseEntity<ArticleReactionsActiveResponse> articleReactionCount(

            @PathVariable("articleId") long articleId,
            @AuthenticationPrincipal MemberDetails member
    ){

        return ResponseEntity.ok(articleReactionCountService.getArticleReactionCount(articleId, member.getId()));
    }


}
