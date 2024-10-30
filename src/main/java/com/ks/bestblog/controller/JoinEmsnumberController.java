package com.ks.bestblog.controller;


import com.ks.bestblog.dto.request.JoinEmsnumberRequest;
import com.ks.bestblog.dto.response.JoinEmsnumberResponse;
import com.ks.bestblog.service.JoinEmsnumberService;
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
