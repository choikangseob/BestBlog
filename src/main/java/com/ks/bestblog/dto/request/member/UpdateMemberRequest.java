package com.ks.bestblog.dto.request.member;

public record UpdateMemberRequest(
        long id,
        String username,
        String password,
        String introduction,
        String profileImageUrl
) {
}
