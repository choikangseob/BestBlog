/*
package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.JoinMemberRequest;
import com.ks.bestblog.dto.response.MemberResponse;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinMemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public MemberResponse joinMember(JoinMemberRequest joinMemberRequest) {

        Member joinMember = Member.from(joinMemberRequest);
        joinMember.setPassword(
                bCryptPasswordEncoder.encode(joinMember.getPassword())
        );

        Member savedMember = memberRepository.save(joinMember);


        return MemberResponse.of(savedMember);
    }

}
*/
