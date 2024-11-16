package com.ks.bestblog.controller.articleReaction;

import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.service.articleReaction.ArticleReactionCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleReactionCountController {

    private final ArticleReactionCountService articleReactionCountService;


    @GetMapping("/articleReactionCount/{articleId}")
    public ResponseEntity<ArticleReaction> articleReactionCount(

            @PathVariable("articleId") long articleId
    ){

        return ResponseEntity.ok(articleReactionCountService.getArticleReactionCount(articleId));
    }


}
