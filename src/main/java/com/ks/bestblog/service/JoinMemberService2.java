/*
package com.ks.bestblog.service;


import com.ks.bestblog.dto.request.JoinMemberRequest2;
import com.ks.bestblog.dto.response.MemberResponse2;
import com.ks.bestblog.entity.Member2;
import com.ks.bestblog.repository.MemberRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinMemberService2 {

    public final MemberRepository2 memberRepository2;
    public final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberResponse2 joinMember(JoinMemberRequest2 joinMemberRequest2){

        Member2 joinMember = Member2.from(joinMemberRequest2);
        joinMember.setPassword(bCryptPasswordEncoder.encode(joinMember.getPassword()));
        Member2 savedMember = memberRepository2.save(joinMember);

        return MemberResponse2.of(savedMember);
    }
}
*/
