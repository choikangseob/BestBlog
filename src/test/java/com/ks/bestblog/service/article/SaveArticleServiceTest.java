package com.ks.bestblog.service.article;

import com.ks.bestblog.common.JWTUtil;
import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.article.SaveArticleRequest;
import com.ks.bestblog.dto.response.article.ArticleResponse;
import com.ks.bestblog.entity.Article;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.article.SaveArticleJPARepository;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class SaveArticleServiceTest {

    @Autowired
    private SaveArticleService saveArticleService;

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
        saveArticleService.saveArticle(getArticleRequest);
        // then
        assertThat(saveArticleService.saveArticle(getArticleRequest)).isNotNull();

        assertSoftly(softly -> {
            softly.assertThat(saveArticleService.saveArticle(getArticleRequest).id()).isEqualTo(getArticleRequest.id());
            softly.assertThat(saveArticleService.saveArticle(getArticleRequest).title()).isEqualTo(getArticleRequest.title());
            softly.assertThat(saveArticleService.saveArticle(getArticleRequest).content()).isEqualTo(getArticleRequest.content());
            softly.assertThat(saveArticleService.saveArticle(getArticleRequest).isPublic()).isEqualTo(getArticleRequest.isPublic());
            softly.assertThat(saveArticleService.saveArticle(getArticleRequest).views()).isEqualTo(getArticleRequest.views());
        });
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