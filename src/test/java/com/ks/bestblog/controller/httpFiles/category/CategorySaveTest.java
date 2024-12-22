package com.ks.bestblog.controller.httpFiles.category;


import com.ks.bestblog.common.JWTUtil;
import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.category.SaveCategoryRequest;
import com.ks.bestblog.dto.response.category.CategoryResponse;
import com.ks.bestblog.entity.Category;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.category.SaveCategoryJPARepository;
import com.ks.bestblog.service.category.SaveCategoryService;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ActiveProfiles("test")
@SpringBootTest
public class CategorySaveTest {

    @Autowired
    private SaveCategoryService saveCategoryService;

    @MockBean
    private JWTUtil jwtUtil;






    @Test
    @DisplayName("카테고리의 리퀘스트가 리스폰스와 일치하는지")
    public void testSaveCategory (){
        // given
        SaveCategoryRequest getCategory = new SaveCategoryRequest(3, 0, 0, "코딩공부");

        MemberDetails memberDetails = new MemberDetails(Member.builder()
                .id(1L)
                .username("최강섭")
                .email("vwko@naver.com")
                .build());

        createJwt(memberDetails);

        // when
        saveCategoryService.saveCategory(getCategory);


        // then
        assertThat(saveCategoryService.saveCategory(getCategory)).isNotNull();

        assertSoftly(softly -> {
            softly.assertThat(saveCategoryService.saveCategory(getCategory).id()).isEqualTo(getCategory.id());
            softly.assertThat(saveCategoryService.saveCategory(getCategory).depth()).isEqualTo(getCategory.depth());
            softly.assertThat(saveCategoryService.saveCategory(getCategory).parentId()).isEqualTo(getCategory.parentId());
            softly.assertThat(saveCategoryService.saveCategory(getCategory).title()).isEqualTo(getCategory.title());

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
