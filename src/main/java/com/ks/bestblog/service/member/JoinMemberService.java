package com.ks.bestblog.service.member;

import com.ks.bestblog.dto.request.member.JoinMemberRequest;
import com.ks.bestblog.dto.response.member.MemberResponse;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.member.MemberJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinMemberService {

    private final MemberJPARepository memberJPARepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public MemberResponse joinMember(JoinMemberRequest joinMemberRequest) {

        Member joinMember = Member.from(joinMemberRequest);
        joinMember.setPassword(
                bCryptPasswordEncoder.encode(joinMember.getPassword())
        );

        Member savedMember = memberJPARepository.save(joinMember);


        return MemberResponse.of(savedMember);
    }

}
