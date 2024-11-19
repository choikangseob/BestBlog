package com.ks.bestblog.controller.article;


import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.service.article.GetArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetArticleController {

    private final GetArticleService getArticleService;



    @GetMapping("/articles/{memberId}")
    public ResponseEntity<List<ArticleResponse>> getArticle(
            @PathVariable("memberId") long id
            ){

        return ResponseEntity.ok(getArticleService.getArticlesByMemeberId(id));



    }

    @GetMapping("/getArticle/{Id}")
    public ResponseEntity<ArticleResponse> getArticle(
            @PathVariable("Id") Long id){

        return ResponseEntity.ok(getArticleService.getArticleById(id));
    }

}
