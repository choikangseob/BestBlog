package com.ks.bestblog.service.article;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.DeleteArticleRequest;
import com.ks.bestblog.dto.response.article.DeleteArticleResponse;
import com.ks.bestblog.entity.Article;
import com.ks.bestblog.repository.article.DeleteArticleJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteArticleService {

    private final DeleteArticleJPARepository deleteArticleJPARepository;

    public DeleteArticleResponse deleteArticle(DeleteArticleRequest deleteArticleRequest, MemberDetails member) {

        Optional<Article> articleOptional = deleteArticleJPARepository.findByIdAndCreateMemberId(deleteArticleRequest.id(), member.getId() );
        Article articleTobeDeleted = articleOptional.orElseThrow(() -> new RuntimeException("결과값이 없습니다"));

        deleteArticleJPARepository.delete(articleTobeDeleted);

        return DeleteArticleResponse.of(articleTobeDeleted);

    }
}
