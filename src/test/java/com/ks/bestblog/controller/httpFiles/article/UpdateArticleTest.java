package com.ks.bestblog.controller.httpFiles.article;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.SaveArticleRequest;
import com.ks.bestblog.dto.request.article.UpdateArticleRequest;
import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.dto.response.article.UpdateArticleResponse;
import com.ks.bestblog.entity.Article;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.article.SaveArticleJPARepository;
import com.ks.bestblog.repository.article.UpdateArticleJPARepository;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ActiveProfiles("test")
@DataJpaTest
public class UpdateArticleTest {

    @Autowired
    private UpdateArticleJPARepository updateArticleJPARepository;

    @Autowired
    private SaveArticleJPARepository saveArticleJPARepository;

    @Test
    @DisplayName("블로그 글의 수정된 리퀘스트와 리스폰스가 일치하는지 테스트")
    public void updateArticleTest (){
        // given
        MemberDetails memberDetails = new MemberDetails(Member.builder()
                .id(1L)
                .username("최강섭")
                .email("vwko@naver.com")
                .build());

        createJwt(memberDetails);

        SaveArticleRequest getArticleRequest = new SaveArticleRequest(1,"코딩 얍얍","취업 아자아자",1,"True",1);
        UpdateArticleRequest getUpdateArticleRequest = new UpdateArticleRequest(1,"코딩 재밌다","취업 꼭 될거야",1,"false");

        // when
    saveArticle(getArticleRequest);
        UpdateArticleResponse updateArticleResponse = updateArticle(getUpdateArticleRequest, memberDetails);
        // then
        assertThat(updateArticleResponse).isNotNull();

        assertSoftly(softly->{
            softly.assertThat(updateArticleResponse.title()).isEqualTo(getUpdateArticleRequest.title());
            softly.assertThat(updateArticleResponse.content()).isEqualTo(getUpdateArticleRequest.content());
            softly.assertThat(updateArticleResponse.isPublic()).isEqualTo(getUpdateArticleRequest.isPublic());
        });
    }

    public ArticleResponse saveArticle(SaveArticleRequest saveArticleRequest){

        Article saveArticle = Article.from(saveArticleRequest);
        Article savedArticle = saveArticleJPARepository.save(saveArticle);

        return ArticleResponse.of(savedArticle);
    }

    public UpdateArticleResponse updateArticle(UpdateArticleRequest updateArticleRequest, MemberDetails member){

        Optional<Article> ArticleOptional = updateArticleJPARepository.findByIdAndCreateMemberId(updateArticleRequest.id(), member.getId());
        Article article = ArticleOptional.orElseThrow(() -> new RuntimeException("결과값이 없습니다"));

        article.setTitle(updateArticleRequest.title());
        article.setContent(updateArticleRequest.content());
        article.setCategoryId(updateArticleRequest.categoryId());
        article.setIsPublic(updateArticleRequest.isPublic());

        return UpdateArticleResponse.of(article);
    }

    public String createJwt(MemberDetails memberDetails) {

        String token = Jwts.builder()
                .claim("username", memberDetails.getUsername())
                .claim("id", memberDetails.getId())
                .claim("role", "")
                .issuedAt(new Date(System.currentTimeMillis()))
                .compact();

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(memberDetails, null, memberDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return token;
    }
}
