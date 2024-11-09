package com.ks.bestblog.controller.category.practice;


import com.ks.bestblog.dto.request.practice.JoinEmsnumberRequest;
import com.ks.bestblog.dto.response.practice.JoinEmsnumberResponse;
import com.ks.bestblog.service.practice.JoinEmsnumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinEmsnumberController {

    private final JoinEmsnumberService joinEmsnumberService;

    @PostMapping("/emsnumber")
    public ResponseEntity<JoinEmsnumberResponse> joinEmsnumber(
            @RequestBody JoinEmsnumberRequest joinEmsnumberRequest
    ){
        return ResponseEntity.ok(joinEmsnumberService.joinEmsnumber(joinEmsnumberRequest));
    }

}
