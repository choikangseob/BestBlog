package com.ks.bestblog.dto.request.member;

public record JoinMemberRequest(
        String username,
        String email,
        String password,
        String introduction,
        String profileImageUrl
) {


}
