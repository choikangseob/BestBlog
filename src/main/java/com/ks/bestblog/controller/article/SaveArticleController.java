package com.ks.bestblog.controller.article;


import com.ks.bestblog.dto.request.article.SaveArticleRequest;
import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.service.article.SaveArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SaveArticleController {

    private final SaveArticleService saveArticleService;

    @PostMapping("/saveArticle")
    public ResponseEntity<ArticleResponse> saveArticle(
            @RequestBody SaveArticleRequest saveArticleRequest

    ){

        return ResponseEntity.ok(saveArticleService.saveArticle(saveArticleRequest));
    }
}
