package com.ks.bestblog.controller.article;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.SaveArticleRequest;
import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.service.article.GetArticleService;
import com.ks.bestblog.service.article.GetLookUpArticleService;
import com.ks.bestblog.service.article.SaveArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetArticleController {

    private final GetArticleService getArticleService;

    private final GetLookUpArticleService getLookUpArticleService;

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> getArticles(

            @AuthenticationPrincipal MemberDetails member
            ){

        return ResponseEntity.ok(getArticleService.getArticlesByMember(member));
    }

    @GetMapping("/articles/{CreateMemberId}")
    public ResponseEntity<List<ArticleResponse>> getArticle(
            @PathVariable("CreateMemberId") long id
            ){

        return ResponseEntity.ok(getLookUpArticleService.getLookUpArticlesByCreateMemeberId(id));


    }
}
