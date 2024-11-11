package com.ks.bestblog.controller.article;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.UpdateArticleRequest;
import com.ks.bestblog.dto.response.article.UpdateArticleResponse;
import com.ks.bestblog.service.article.UpdateArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateArticleController {

    private final UpdateArticleService updateArticleService;

    @PostMapping("/updateArticle")
    public ResponseEntity<UpdateArticleResponse> updateArticle(

            @RequestBody UpdateArticleRequest updateArticleRequest,
            @AuthenticationPrincipal MemberDetails member
    ){

        return ResponseEntity.ok(updateArticleService.updateArticle(updateArticleRequest,member));
    }
}
