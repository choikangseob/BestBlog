package com.ks.bestblog.controller;

import com.ks.bestblog.dto.request.TestRequest;
import com.ks.bestblog.dto.response.TestResponse;
import com.ks.bestblog.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    public final TestService testService;

    @PostMapping("/test")
    public ResponseEntity<TestResponse> test(
            @RequestBody TestRequest testRequest
    ) {

        return ResponseEntity.ok(testService.test(testRequest));
    }
}
