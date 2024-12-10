package com.ks.bestblog.controller.httpFiles;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.member.MemberJPARepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class loadUserByUsernameTest {

    @Autowired
    private MemberJPARepository memberJPARepository;

    @Test
    @DisplayName("loadUserByUsername에 인수로 보낸 값이 제대로 전달되었는지 확인하는 테스트")
    public void loadUserByUsername(){
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
        UserDetails userDetails = loadUserByUsername(savedMember.getEmail());
        // then
        assertThat(userDetails)
                .isNotNull()
                .extracting(UserDetails::getUsername)
                .isEqualTo("vwko@naver.com");
    }

    public UserDetails loadUserByUsername(String email) {
        Optional<Member> member = memberJPARepository.findByEmail(email);
        Optional<MemberDetails> memberDetails = member.map(MemberDetails::new);
        return memberDetails.orElse(null);
    }
}
