package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.JoinMemberRequest;
import com.ks.bestblog.dto.response.MemberResponse;

public interface JoinMemberService {
    MemberResponse joinMember(JoinMemberRequest joinMemberRequest);
}
