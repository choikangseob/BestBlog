package com.ks.bestblog.service;


import com.ks.bestblog.dto.request.JoinMemberRequest;
import com.ks.bestblog.dto.response.MemberResponse;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinMemberServiceImpl implements JoinMemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public MemberResponse joinMember(JoinMemberRequest joinMemberRequest) {

        Member member = Member.from(joinMemberRequest);
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        Member savedMember = memberRepository.save(member);
        return MemberResponse.of(savedMember);
    }
}
