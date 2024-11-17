package com.ks.bestblog.dto.response.member;

import com.ks.bestblog.entity.Member;
import lombok.Builder;

@Builder
public record MemberResponse(
        Long id,
        String username,
        String email,
        String introduction,
        String profileImageUrl
) {

    public static MemberResponse of(Member savedMember) {
        return MemberResponse.builder()
                .id(savedMember.getId())
                .username(savedMember.getUsername())
                .email(savedMember.getEmail())
                .introduction(savedMember.getIntroduction())
                .profileImageUrl(savedMember.getProfileImageUrl())
                .build();
    }
}
