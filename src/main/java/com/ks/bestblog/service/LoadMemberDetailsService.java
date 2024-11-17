package com.ks.bestblog.service;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.member.MemberJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoadMemberDetailsService implements UserDetailsService {

    private final MemberJPARepository memberJPARepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            Optional<Member> member = memberJPARepository.findByEmail(email);

            Optional<MemberDetails> memberDetails = member.map(MemberDetails::new);

        return memberDetails.orElse(null);
    }
}
