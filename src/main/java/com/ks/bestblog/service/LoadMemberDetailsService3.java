/*
package com.ks.bestblog.service;

import com.ks.bestblog.common.MemberDetails3;
import com.ks.bestblog.entity.Member3;
import com.ks.bestblog.repository.MemberRepository3;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoadMemberDetailsService3 implements UserDetailsService {

    private final MemberRepository3 memberRepository3;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Member3> userData = memberRepository3.findByEmail(email);

        // `Member2`를 인자로 받는 생성자가 `MemberDetails2`에 있는지 확인하세요.
        Optional<MemberDetails3> memberDetails3 = userData.map(MemberDetails3::new);

        return memberDetails3.orElse(null);
    }
}
*/
