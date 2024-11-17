package com.ks.bestblog.service.articleReaction;


import com.ks.bestblog.dto.response.articleReaction.ArticleReactionsActiveResponse;
import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.enums.ArticleReactionType;
import com.ks.bestblog.repository.articleReaction.ArticleReactionJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleReactionCountService {

    private final ArticleReactionJPARepository articleReactionJPARepository;

    public ArticleReactionsActiveResponse getArticleReactionCount(long articleId,long memberId) {

        List<ArticleReaction> allGetArticleReactionList = articleReactionJPARepository.findAllByArticleIdAndCreateMemberId(articleId,memberId);
        Map<String, List<ArticleReaction>> groupedArticleReactionList = allGetArticleReactionList.stream()
                .collect(Collectors.groupingBy(articleReaction -> articleReaction.getType().toString()));


        ArticleReactionsActiveResponse articleReactionsActiveResponse = ArticleReactionsActiveResponse.builder()
                .build();


        Arrays.stream(ArticleReactionType.values()).forEach(
                articleReactionType -> {
                    System.out.println("articleReactionType: " + articleReactionType);

                    AtomicBoolean hasTypeRow = new AtomicBoolean(false);




                    groupedArticleReactionList.forEach((key, value) -> {

                        if(key.equals(articleReactionType.name())){
                            hasTypeRow.set(true);
                        }


                    });


                    System.out.println(articleReactionType + " hasTypeRow: " + hasTypeRow.get());


                    articleReactionsActiveResponse.from(articleReactionType, hasTypeRow.get());
                }



                );


        return articleReactionsActiveResponse;


    }
}
