package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Member3;
import lombok.Builder;

@Builder
public record MemberResponse3(
        int id,
        String username,
        String email,
        String password
) {

    public static MemberResponse3 of(Member3 joinMember){

        return MemberResponse3.builder()
                .id(joinMember.getId())
                .username(joinMember.getUsername())
                .email(joinMember.getEmail())
                .password(joinMember.getPassword())
                .build();


    }
}
