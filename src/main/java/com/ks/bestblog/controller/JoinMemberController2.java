/*
package com.ks.bestblog.controller;


import com.ks.bestblog.dto.request.JoinMemberRequest2;
import com.ks.bestblog.dto.response.MemberResponse2;
import com.ks.bestblog.service.JoinMemberService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinMemberController2 {

    public final JoinMemberService2 joinMemberService2;

    @PostMapping("/member2")
    public ResponseEntity<MemberResponse2> joinMember(

            @RequestBody JoinMemberRequest2 joinMemberRequest2
    ){

        return ResponseEntity.ok(joinMemberService2.joinMember(joinMemberRequest2));
    }

}
*/
