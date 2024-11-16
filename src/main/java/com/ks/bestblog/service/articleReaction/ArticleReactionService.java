package com.ks.bestblog.service.articleReaction;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.articleReaction.ArticleReactionResponse;
import com.ks.bestblog.entity.ArticleReaction;
import com.ks.bestblog.enums.ArticleReactionType;
import com.ks.bestblog.repository.articleReaction.ArticleReactionJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleReactionService {

    private final ArticleReactionJPARepository articleReactionJPARepository;

    public ArticleReactionResponse articleReaction(long articleId, ArticleReactionType type, MemberDetails member){
        Optional<ArticleReaction> articleReaction = articleReactionJPARepository.findByArticleIdAndTypeAndCreateMemberId(articleId,type,member.getId());

        ArticleReaction savedAction = null;

        String processedResultType = "INSERTED";

        if(articleReaction.isPresent()){

            articleReactionJPARepository.deleteById(articleReaction.get().getId());

            savedAction = articleReaction.get();
            processedResultType = "DELETED";

        }else{

            ArticleReaction insertAction = ArticleReaction.from(articleId,type,member);
            savedAction = articleReactionJPARepository.save(insertAction);




        }

        return ArticleReactionResponse.of(savedAction , processedResultType);
    }

}
