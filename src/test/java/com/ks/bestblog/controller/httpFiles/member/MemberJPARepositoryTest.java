package com.ks.bestblog.controller.httpFiles.member;


import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.member.MemberJPARepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase
public class MemberJPARepositoryTest {

    @Autowired
    private MemberJPARepository memberJPARepository;



    @Test
    @DisplayName("회원가입이 완료되었는지를 테스트")
   public void save (){
        // given

        Member  member = Member.builder()
                .username("최강섭")
                .email("vwko@naver.com")
                .password("123123")
                .introduction("열심히 해보자구요")
                .profileImageUrl("/image")
                .build();

        // when
        Member savedMember = memberJPARepository.save(member);

        // then
        assertThat(savedMember).isNotNull();

        assertSoftly(softly -> {
            softly.assertThat(savedMember.getUsername()).isEqualTo(member.getUsername());
            softly.assertThat(savedMember.getEmail()).isEqualTo(member.getEmail());
            softly.assertThat(savedMember.getIntroduction()).isEqualTo(member.getIntroduction());
            softly.assertThat(savedMember.getProfileImageUrl()).isEqualTo(member.getProfileImageUrl());
        });
    }


}
