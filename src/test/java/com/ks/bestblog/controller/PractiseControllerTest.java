package com.ks.bestblog.controller;

import com.ks.bestblog.dto.response.PractiseExampleResponse;
import com.ks.bestblog.service.PractiseService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PractiseControllerTest {

    @Test
    void getPractiseExampleOne(){
        //Given
        PractiseController practiseController = new PractiseController(
                new PractiseService()
        );
        //When
        PractiseExampleResponse PractiseExampleOne = practiseController.getPractiseExampleOne();
        //Then
        assertThat(PractiseExampleOne.getUsername()).isEqualTo("choiKangSeob");
        assertThat(PractiseExampleOne.getEmail()).isEqualTo("vwko@naver.com");
    }
}