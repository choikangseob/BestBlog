package com.ks.bestblog.dto.response;

import com.ks.bestblog.dto.request.JoinMemberRequest1;
import com.ks.bestblog.entity.Member1;
import lombok.Builder;

@Builder
public record MemberResponse1(
        int id,
        String username,
        String email

) {
    public static MemberResponse1 of (Member1 joinMember){
        return MemberResponse1.builder()
                .id(joinMember.getId())
                .username(joinMember.getUsername())
                .email(joinMember.getEmail())
                .build();
    }
}
