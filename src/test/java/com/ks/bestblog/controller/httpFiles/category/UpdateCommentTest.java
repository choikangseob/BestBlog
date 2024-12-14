package com.ks.bestblog.controller.httpFiles.category;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.category.SaveCategoryRequest;
import com.ks.bestblog.dto.request.category.UpdateCategoryRequest;
import com.ks.bestblog.dto.response.category.CategoryResponse;
import com.ks.bestblog.dto.response.category.UpdateCategoryResponse;
import com.ks.bestblog.entity.Category;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.category.SaveCategoryJPARepository;
import com.ks.bestblog.repository.category.UpdateCategoryJPARepository;
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
    private UpdateCategoryJPARepository updateCategoryJPARepository;

    @Autowired
    private SaveCategoryJPARepository saveCategoryJPARepository;

    @Test
    @DisplayName("카테고리를 수정시 수정할때의 리퀘스트와 리스폰스가 일치하는지 테스트")
    public void updateCategoryTest (){
        // given
    MemberDetails memberDetails = new MemberDetails(Member.builder()
            .id(1L)
            .username("최강섭")
            .email("vwko@naver.com")
            .build());

    createJwt(memberDetails);

    SaveCategoryRequest getCategoryRequest = new SaveCategoryRequest(1,0,0,"코딩테스트");

    UpdateCategoryRequest updateCategoryRequest = new UpdateCategoryRequest(1,0,"코딩 테스트 재밌어요");

        // when
        CategoryResponse savedCategoryResponse = saveCategory(getCategoryRequest);

        UpdateCategoryResponse updateCategoryResponse = updateCategory(updateCategoryRequest, memberDetails);

        // then
        assertThat(updateCategoryResponse).isNotNull();

        assertSoftly(softly -> {
            softly.assertThat(updateCategoryResponse.title()).isEqualTo(updateCategoryRequest.title()).isEqualTo("코딩 테스트 재밌어요");

        });
    }

    public CategoryResponse saveCategory(SaveCategoryRequest saveCategoryRequest){

        Category category = Category.from(saveCategoryRequest);
        Category savedCategory = saveCategoryJPARepository.save(category);

        return CategoryResponse.of(savedCategory);
    }

    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest, MemberDetails member) {

        Optional<Category> categoryOptional = updateCategoryJPARepository.findByIdAndCreateMemberId(updateCategoryRequest.id(),member.getId());
        Category category = categoryOptional.orElseThrow(() -> new RuntimeException("결과값이 없습니다"));


        category.setDepth(updateCategoryRequest.depth());
        category.setTitle(updateCategoryRequest.title());

        return UpdateCategoryResponse.of(category);

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
