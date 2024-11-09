package com.ks.bestblog.dto.response.practice;


import lombok.Builder;
import lombok.Getter;

@Getter
public class PractiseExampleResponse {
    private String username;
    private String email;

    @Builder
    public PractiseExampleResponse(String username, String email) {

        this.username = username;
        this.email = email;
    }
}

