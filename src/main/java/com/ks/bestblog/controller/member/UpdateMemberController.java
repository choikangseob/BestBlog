package com.ks.bestblog.controller.member;


import com.ks.bestblog.dto.request.member.UpdateMemberRequest;
import com.ks.bestblog.dto.response.member.UpdateMemberResponse;
import com.ks.bestblog.service.member.UpdateMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateMemberController {

    private final UpdateMemberService updateMemberService;

    @PostMapping("/updateMember")
    public ResponseEntity<UpdateMemberResponse> updateMember(
            @RequestBody UpdateMemberRequest updateMemberRequest

            ) {

        return ResponseEntity.ok(updateMemberService.updateMember(updateMemberRequest));
    }
}
