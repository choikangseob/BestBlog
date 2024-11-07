package com.ks.bestblog.service;


import com.ks.bestblog.dto.request.JoinMemberRequest3;
import com.ks.bestblog.dto.response.MemberResponse3;
import com.ks.bestblog.entity.Member3;
import com.ks.bestblog.repository.MemberRepository3;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinMemberService3 {

    public final MemberRepository3 memberRepository3;
    public final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberResponse3 joinMember(JoinMemberRequest3 joinMemberRequest3){

         Member3 joinMember = Member3.from(joinMemberRequest3);
         joinMember.setPassword(bCryptPasswordEncoder.encode(joinMember.getPassword()));

         Member3 savedMember = memberRepository3.save(joinMember);

         return MemberResponse3.of(savedMember);
    }

}
