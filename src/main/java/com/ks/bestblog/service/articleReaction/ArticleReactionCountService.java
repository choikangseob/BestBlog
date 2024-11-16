package com.ks.bestblog.service.articleReaction;


import com.ks.bestblog.dto.response.articleReaction.ArticleReactionResponse;
import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.repository.articleReaction.ArticleReactionJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleReactionCountService {

    private final ArticleReactionJPARepository articleReactionJPARepository;

    public List<ArticleReactionResponse> getArticleReactionCount(long articleId) {

        List<ArticleReaction> allGetArticleReactionList = articleReactionJPARepository.findAllByArticleId(articleId);
        Map<String, List<ArticleReaction>> groupedArticleReactionList = allGetArticleReactionList.stream().collect(Collectors.groupingBy(articleReaction -> articleReaction.getType().toString()));


        return null;
    }
}
