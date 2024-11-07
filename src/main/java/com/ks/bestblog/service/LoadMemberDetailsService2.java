/*
package com.ks.bestblog.service;

import com.ks.bestblog.common.MemberDetails2;
import com.ks.bestblog.entity.Member2;
import com.ks.bestblog.repository.MemberRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoadMemberDetailsService2 implements UserDetailsService {

   public final MemberRepository2 memberRepository2;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member2> userData = memberRepository2.findByEmail(email);

        // `Member2`를 인자로 받는 생성자가 `MemberDetails2`에 있는지 확인하세요.
        Optional<MemberDetails2> memberDetails2 = userData.map(MemberDetails2::new);

        return memberDetails2.orElse(null);
    }
}
*/
