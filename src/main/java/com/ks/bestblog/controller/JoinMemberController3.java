package com.ks.bestblog.controller;


import com.ks.bestblog.dto.request.JoinMemberRequest3;
import com.ks.bestblog.dto.response.MemberResponse3;
import com.ks.bestblog.service.JoinMemberService3;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinMemberController3 {

    public final JoinMemberService3 joinMemberService3;

    @PostMapping("/member3")
    public ResponseEntity<MemberResponse3> joinMember(

            @RequestBody JoinMemberRequest3 joinMemberRequest3
    ){

        return ResponseEntity.ok(joinMemberService3.joinMember(joinMemberRequest3));
    }

}
