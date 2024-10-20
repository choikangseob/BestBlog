package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Member;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("local")
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("")
    @Description("")
    void test() {
        Optional<Member> member = memberRepository.findById(1L);
        assertThat(member.isPresent()).isTrue();

    }

    @Test
    @DisplayName("")
    @Description("")
    void test2() {
        List<Member> allMemberList = memberRepository.findAll();

        allMemberList.forEach(member -> {
            System.out.println(member.getId());
            System.out.println(member.getUsername());
            System.out.println(member.getEmail());
            System.out.println(member.getPassword());

        });


    }
    @Test
    @DisplayName("")
    @Description("")
    void test3() {
      Optional<Member> member = memberRepository.findByUsername("gs");


    }

}
