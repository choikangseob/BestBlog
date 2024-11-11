package com.ks.bestblog.controller.article;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.DeleteArticleRequest;
import com.ks.bestblog.dto.response.DeleteArticleResponse;
import com.ks.bestblog.service.article.DeleteArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteArticleController {

    private final DeleteArticleService deleteArticleService;

    @PostMapping("/deleteArticle")
    public ResponseEntity<DeleteArticleResponse> deleteArticle(
            @RequestBody DeleteArticleRequest deleteArticleRequest,
            @AuthenticationPrincipal MemberDetails member

            ){

        return ResponseEntity.ok(deleteArticleService.deleteArticle(deleteArticleRequest,member));
    }

}
