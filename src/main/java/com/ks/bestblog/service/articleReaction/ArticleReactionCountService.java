package com.ks.bestblog.service.articleReaction;


import com.ks.bestblog.dto.response.articleReaction.ArticleReactionResponse;
import com.ks.bestblog.repository.articleReaction.ArticleReactionJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleReactionCountService {

    private final ArticleReactionJPARepository articleReactionJPARepository;

    public ArticleReactionResponse getArticleReactionCount(long articleId) {

        return articleReactionJPARepository.findAllArticleId(articleId);
    }
}
