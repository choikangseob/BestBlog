package com.ks.bestblog.dto.request;

import lombok.Builder;

@Builder
public record JoinMemberRequest(

    String username,
    String email,
    String password
) {

}
