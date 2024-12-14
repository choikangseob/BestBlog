package com.ks.bestblog.controller.httpFiles.article;


import com.ks.bestblog.common.JWTUtil;
import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.SaveArticleRequest;
import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.Article;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.article.SaveArticleJPARepository;
import com.ks.bestblog.service.article.SaveArticleService;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ActiveProfiles("test")
@DataJpaTest
public class articleSaveTest {

    @Autowired
    private SaveArticleJPARepository saveArticleJPARepository;

    @MockBean
    private JWTUtil jwtUtil;



    @Test
    @DisplayName("아티클의 리퀘스트가 리스폰스와 일치하는지 테스트")
    public void saveArticleTest (){
        // given
        SaveArticleRequest getArticleRequest = new SaveArticleRequest(1,"오늘도 힘차게 코딩","코딩은 즐겁습니다",1,"true",1);

        MemberDetails memberDetails = new MemberDetails(Member.builder()
                .username("최강섭")
                .email("vwko@naver.com")
                .password("123123")
                .build());

        createJwt(memberDetails);
        // when
        ArticleResponse articleResponse = saveArticle(getArticleRequest);
        // then
        assertThat(articleResponse).isNotNull();

        assertSoftly(softly -> {
            softly.assertThat(articleResponse.id()).isEqualTo(getArticleRequest.id());
            softly.assertThat(articleResponse.title()).isEqualTo(getArticleRequest.title());
            softly.assertThat(articleResponse.content()).isEqualTo(getArticleRequest.content());
            softly.assertThat(articleResponse.isPublic()).isEqualTo(getArticleRequest.isPublic());
            softly.assertThat(articleResponse.views()).isEqualTo(getArticleRequest.views());
        });
    }

    public ArticleResponse saveArticle(SaveArticleRequest saveArticleRequest){

        Article saveArticle = Article.from(saveArticleRequest);
        Article savedArticle = saveArticleJPARepository.save(saveArticle);

        return ArticleResponse.of(savedArticle);
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
