package com.ks.bestblog.service.article;


import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.repository.article.ViewArticleMybatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewArticleService {

    private final ViewArticleMybatisRepository viewArticleMybatisRepository;

    public List<ArticleResponse> viewArticleByIdAndTitle(Long id) {



        return viewArticleMybatisRepository.findByIdAndTitle(id);


    }

}
