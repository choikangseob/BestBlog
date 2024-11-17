package com.ks.bestblog.service.member;


import com.ks.bestblog.dto.request.member.UpdateMemberRequest;
import com.ks.bestblog.dto.response.member.UpdateMemberResponse;
import com.ks.bestblog.entity.Member;
import com.ks.bestblog.repository.member.UpdateMemberJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateMemberService {

    private final UpdateMemberJPARepository updateMemberJPARepository;


    public UpdateMemberResponse updateMember(UpdateMemberRequest updateMemberRequest) {

        Optional<Member> memberOptional = updateMemberJPARepository.findById(updateMemberRequest.id());
        Member member = memberOptional.orElseThrow(()->new RuntimeException("수정할 값이 없습니다"));

        member.setIntroduction(updateMemberRequest.introduction());
        member.setProfileImageUrl(updateMemberRequest.profileImageUrl());

        return UpdateMemberResponse.of(member);

    }
}
