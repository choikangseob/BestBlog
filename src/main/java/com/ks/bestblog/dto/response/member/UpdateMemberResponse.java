package com.ks.bestblog.dto.response.member;

import com.ks.bestblog.entity.Member;
import lombok.Builder;

@Builder
public record UpdateMemberResponse(
        long id,
        String introduction,
        String profileImageUrl
) {

    public static UpdateMemberResponse of(Member updateMember) {
        return UpdateMemberResponse.builder()
                .id(updateMember.getId())
                .introduction(updateMember.getIntroduction())
                .profileImageUrl(updateMember.getProfileImageUrl())
                .build();
    }
}
