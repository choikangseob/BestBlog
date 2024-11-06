package com.ks.bestblog.dto.request;

public record JoinMemberRequest2(
        int id,
        String username,
        String email,
        String password
) {
}
