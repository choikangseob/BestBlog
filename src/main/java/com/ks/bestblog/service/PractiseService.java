package com.ks.bestblog.service;

import com.ks.bestblog.dto.response.PractiseExampleResponse;
import org.springframework.stereotype.Service;

@Service
public class PractiseService {
    public static PractiseExampleResponse getPractiseExampleOne() {
        return PractiseExampleResponse.builder()
        .username("choiKangSeob")
        .email("vwko@naver.com")
        .build();
    }
}
