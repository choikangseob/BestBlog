package com.ks.bestblog.service.article;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.DeleteArticleRequest;
import com.ks.bestblog.dto.response.DeleteArticleResponse;
import com.ks.bestblog.entity.Article;
import com.ks.bestblog.repository.article.DeleteArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteArticleService {

    private final DeleteArticleRepository deleteArticleRepository;

    public DeleteArticleResponse deleteArticle(DeleteArticleRequest deleteArticleRequest, MemberDetails member) {

        Optional<Article> articleOptional = deleteArticleRepository.findByIdAndCreateMemberId(deleteArticleRequest.id(), member.getId() );
        Article articleTobeDeleted = articleOptional.orElseThrow(() -> new RuntimeException("결과값이 없습니다"));

        deleteArticleRepository.delete(articleTobeDeleted);

        return DeleteArticleResponse.of(articleTobeDeleted);

    }
}
