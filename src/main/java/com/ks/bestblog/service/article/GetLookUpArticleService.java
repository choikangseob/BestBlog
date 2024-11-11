package com.ks.bestblog.service.article;

import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.repository.article.ArticleMybatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetLookUpArticleService {

    private final ArticleMybatisRepository articleMybatisRepository;


    public List<ArticleResponse> getLookUpArticlesByCreateMemeberId(long id) {

        return articleMybatisRepository.findByCreateMemberId(id);
    }
}
