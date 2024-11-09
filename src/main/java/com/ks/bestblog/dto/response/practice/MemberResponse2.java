/*
package com.ks.bestblog.dto.response;

import com.ks.bestblog.dto.request.JoinMemberRequest2;
import com.ks.bestblog.entity.Member2;
import lombok.Builder;

@Builder
public record MemberResponse2(
        int id,
        String username,
        String Email,
        String password
) {
    public static MemberResponse2 of(Member2 joinMember){
        return MemberResponse2.builder()
                .id(joinMember.getId())
                .username(joinMember.getUsername())
                .Email(joinMember.getEmail())
                .password(joinMember.getPassword())
                .build();
    }
}
*/
