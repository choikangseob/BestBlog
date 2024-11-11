package com.ks.bestblog.service.article;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.repository.article.ArticleMybatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticleService {

    private final ArticleMybatisRepository articleMybatisRepository;

    public List<ArticleResponse> getArticlesByMember(MemberDetails member) {

        return articleMybatisRepository.findAllByMemberId(member.getId());



    }
}
