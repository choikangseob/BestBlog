package com.ks.bestblog.service.article;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.UpdateArticleRequest;
import com.ks.bestblog.dto.response.article.UpdateArticleResponse;
import com.ks.bestblog.entity.Article;
import com.ks.bestblog.repository.article.UpdateArticleJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateArticleService {

    private final UpdateArticleJPARepository updateArticleJPARepository;
    public UpdateArticleResponse updateArticle(UpdateArticleRequest updateArticleRequest, MemberDetails member){

        Optional<Article> ArticleOptional = updateArticleJPARepository.findByIdAndCreateMemberId(updateArticleRequest.id(), member.getId());
        Article article = ArticleOptional.orElseThrow(() -> new RuntimeException("결과값이 없습니다"));

        article.setTitle(updateArticleRequest.title());
        article.setContent(updateArticleRequest.content());
        article.setCategoryId(updateArticleRequest.categoryId());
        article.setIsPublic(updateArticleRequest.isPublic());

        return UpdateArticleResponse.of(article);
    }
}
