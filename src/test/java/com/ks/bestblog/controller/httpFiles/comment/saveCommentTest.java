package com.ks.bestblog.controller.httpFiles.comment;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.comment.SaveCommentRequest;
import com.ks.bestblog.dto.response.comment.CommentResponse;
import com.ks.bestblog.entity.Comment;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.comment.SaveCommentJPARepository;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ActiveProfiles("test")
@DataJpaTest
public class saveCommentTest {

    @Autowired
    private SaveCommentJPARepository saveCommentJPARepository;

    @Test
    @DisplayName("댓글의 리퀘스트가 리스폰스와 일치하는지 테스트")
    public void saveCommentTest (){
        // given
    SaveCommentRequest getCommentRequest = new SaveCommentRequest(1,1,0,0,"공감됩니다");

        MemberDetails memberDetails = new MemberDetails(Member.builder()
                .id(1L)
                .username("최강섭")
                .email("vwko@naver.com")
                .build());

        createJwt(memberDetails);


        // when
   CommentResponse savedComment = saveComment(getCommentRequest);

        // then

        assertThat(savedComment).isNotNull();

        assertSoftly(softly -> {
            softly.assertThat(savedComment.id()).isEqualTo(getCommentRequest.id());
            softly.assertThat(savedComment.articleId()).isEqualTo(getCommentRequest.articleId());
            softly.assertThat(savedComment.depth()).isEqualTo(getCommentRequest.depth());
            softly.assertThat(savedComment.parentId()).isEqualTo(getCommentRequest.parentId());
            softly.assertThat(savedComment.Comment()).isEqualTo(getCommentRequest.comment());
        });
    }



    public CommentResponse saveComment(SaveCommentRequest saveCommentRequest){

        Comment saveComment = Comment.from(saveCommentRequest);
        Comment savedComment = saveCommentJPARepository.save(saveComment);

        return CommentResponse.of(savedComment);
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
