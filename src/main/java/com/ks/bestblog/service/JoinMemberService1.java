/*
package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.JoinMemberRequest1;
import com.ks.bestblog.dto.response.MemberResponse1;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.entity.Member1;
import com.ks.bestblog.repository.MemberRepository;
import com.ks.bestblog.repository.MemberRepository1;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinMemberService1 {

    public final MemberRepository1 memberRepository1;
    public final BCryptPasswordEncoder bCryptPasswordEncoder;
    public MemberResponse1 joinMember(JoinMemberRequest1 joinMemberRequest1) {

        Member1 joinMember = Member1.from(joinMemberRequest1);
        joinMember.setPassword(bCryptPasswordEncoder.encode(joinMember.getPassword()));
        Member1 savedMember = memberRepository1.save(joinMember);

        return MemberResponse1.of(savedMember);
    }
}
*/
