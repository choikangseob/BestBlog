package com.ks.bestblog.service;

import com.ks.bestblog.common.MemberDetails1;
import com.ks.bestblog.entity.Member1;
import com.ks.bestblog.repository.MemberRepository1;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoadMemberDetailsService1 implements UserDetailsService {

    public final MemberRepository1 memberRepository1;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Member1> member =memberRepository1.findByEmail(email);

        Optional<MemberDetails1> memberDetails1 = member.map(MemberDetails1::new);

        return memberDetails1.orElse(null);
    }
}
