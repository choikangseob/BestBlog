package com.ks.bestblog.controller;

import com.ks.bestblog.dto.request.JoinMemberRequest1;
import com.ks.bestblog.dto.response.MemberResponse1;
import com.ks.bestblog.service.JoinMemberService;
import com.ks.bestblog.service.JoinMemberService1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinMemberController1 {

    public final JoinMemberService1 joinMemberService1;

    @PostMapping("/member1")
    public ResponseEntity<MemberResponse1> joinMember(
            @RequestBody JoinMemberRequest1 joinMemberRequest1 // 수정된 부분
    ){


        return ResponseEntity.ok(joinMemberService1.joinMember(joinMemberRequest1));
    }
}
