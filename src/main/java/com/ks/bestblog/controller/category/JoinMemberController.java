package com.ks.bestblog.controller.category;

import com.ks.bestblog.dto.request.category.JoinMemberRequest;
import com.ks.bestblog.dto.response.category.MemberResponse;
import com.ks.bestblog.service.JoinMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinMemberController {
    private final JoinMemberService joinMemberService;

    @PostMapping("/member")
    public ResponseEntity<MemberResponse> joinMember(

            @RequestBody JoinMemberRequest joinMemberRequest
            ) {

        return ResponseEntity.ok(joinMemberService.joinMember(joinMemberRequest));
    }

}
