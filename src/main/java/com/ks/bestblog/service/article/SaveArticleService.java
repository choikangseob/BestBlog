package com.ks.bestblog.service.article;


import com.ks.bestblog.dto.request.article.SaveArticleRequest;
import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.Article;
import com.ks.bestblog.repository.article.SaveArticleJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveArticleService {

    private final SaveArticleJPARepository saveArticleJPARepository;

    public ArticleResponse saveArticle(SaveArticleRequest saveArticleRequest){

        Article saveArticle = Article.from(saveArticleRequest);
        Article savedArticle = saveArticleJPARepository.save(saveArticle);

        return ArticleResponse.of(savedArticle);
    }
}
