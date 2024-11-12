package com.ks.bestblog.controller.article;


import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.service.article.ViewArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ViewArticleController {

    private final ViewArticleService viewArticleService;

    @GetMapping("/viewArticle/{Id}")
    public ResponseEntity<List<ArticleResponse>> viewArticle(
            @PathVariable("Id") Long id){

        return ResponseEntity.ok(viewArticleService.viewArticleByIdAndTitle(id));
    }
}
