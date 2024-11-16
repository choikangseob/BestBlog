package com.ks.bestblog.service.article;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.Article;
import com.ks.bestblog.repository.article.ArticleJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetArticleService {

    private final ArticleJPARepository articleJPARepository;


    public List<ArticleResponse> getArticlesByMemeberId(long id) {

        return articleJPARepository.findByCreateMemberId(id);
    }


    public ArticleResponse getArticleById(Long id) {

        Optional<Article> articleOpt = articleJPARepository.findById(id);
        Article article = articleOpt.orElseThrow(() -> new RuntimeException("값이 없습니다"));

        return ArticleResponse.of(article);

    }
}
