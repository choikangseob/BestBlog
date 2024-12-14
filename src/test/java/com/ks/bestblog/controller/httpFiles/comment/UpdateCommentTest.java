package com.ks.bestblog.controller.httpFiles.comment;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.comment.SaveCommentRequest;
import com.ks.bestblog.dto.request.comment.UpdateCommentRequest;
import com.ks.bestblog.dto.response.comment.CommentResponse;
import com.ks.bestblog.dto.response.comment.UpdateCommentResponse;
import com.ks.bestblog.entity.Comment;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.category.UpdateCategoryJPARepository;
import com.ks.bestblog.repository.comment.SaveCommentJPARepository;
import com.ks.bestblog.repository.comment.UpdateCommentJPARepository;
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
public class UpdateCommentTest {

    @Autowired
    private SaveCommentJPARepository saveCommentJPARepository;

    @Autowired
    private UpdateCommentJPARepository updateCommentJPARepository;


    @Test
    @DisplayName("댓글 업데이트의 리스폰스와 리퀘스트가 일치하는지 테스트")
    public void updateCommentTest (){
        // given
        MemberDetails memberDetails = new MemberDetails(Member.builder()
                .id(1L)
                .username("최강섭")
                .email("vwko@naver.com")
                .build());

        createJwt(memberDetails);

        SaveCommentRequest getCommentRequest = new SaveCommentRequest(1, 1, 0, 1, "와 생각해보지못한 발상법이네요");

        UpdateCommentRequest getUpdateCommentRequest = new UpdateCommentRequest(1, 1, 0, 1, "일취월장하고싶습니다");
        // when
        saveComment(getCommentRequest);

        UpdateCommentResponse updateCommentResponse = updateComment(getUpdateCommentRequest, memberDetails);

        // then
        assertThat(updateCommentResponse).isNotNull();

        assertSoftly(softly->{
            softly.assertThat(updateCommentResponse.id()).isEqualTo(getUpdateCommentRequest.id());
            softly.assertThat(updateCommentResponse.articleId()).isEqualTo(getUpdateCommentRequest.articleId());
            softly.assertThat(updateCommentResponse.depth()).isEqualTo(getUpdateCommentRequest.depth());
            softly.assertThat(updateCommentResponse.parentId()).isEqualTo(getUpdateCommentRequest.parentId());
            softly.assertThat(updateCommentResponse.comment()).isEqualTo(getUpdateCommentRequest.comment());

        });
    }

    public CommentResponse saveComment(SaveCommentRequest saveCommentRequest){

        Comment saveComment = Comment.from(saveCommentRequest);
        Comment savedComment = saveCommentJPARepository.save(saveComment);

        return CommentResponse.of(savedComment);
    }

    public UpdateCommentResponse updateComment(UpdateCommentRequest updateCommentRequest, MemberDetails member){

        Optional<Comment> commentOptional = updateCommentJPARepository.findByIdAndCreateMemberId(updateCommentRequest.id(), member.getId());
        Comment comment =  commentOptional.orElseThrow(()-> new RuntimeException("수정할 항목이 존재하지 않습니다"));

        comment.setArticleId(updateCommentRequest.articleId());
        comment.setDepth(updateCommentRequest.depth());
        comment.setParentId(updateCommentRequest.parentId());
        comment.setComment(updateCommentRequest.comment());

        return UpdateCommentResponse.of(comment);

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
