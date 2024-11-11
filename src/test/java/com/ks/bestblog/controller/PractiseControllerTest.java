package com.ks.bestblog.controller;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.controller.practice.PractiseController;
import com.ks.bestblog.dto.response.practice.PractiseExampleResponse;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.service.practice.PractiseService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PractiseControllerTest {

    @Test
    void getPractiseExampleOne(){
        //Given
        PractiseController practiseController = new PractiseController(
                new PractiseService()
        );
        Member member = new Member();
        member.setId(1L);
        member.setEmail("vwko123456@naver.com");
        MemberDetails memberDetails = new MemberDetails(member);
        //When
        PractiseExampleResponse PractiseExampleOne = practiseController.getPractiseExampleOne(memberDetails);
        //Then
        assertThat(PractiseExampleOne.getUsername()).isEqualTo("choiKangSeob");
        assertThat(PractiseExampleOne.getEmail()).isEqualTo("vwko@naver.com");
    }
}