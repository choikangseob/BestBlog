package com.ks.bestblog.controller;

import com.ks.bestblog.dto.request.JoinCustomerRequest;
import com.ks.bestblog.dto.response.JoinCustomerResponse;
import com.ks.bestblog.service.JoinCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinCustomerController {
public final JoinCustomerService joinCustomerService;

    @PostMapping("/customer")
    public ResponseEntity<JoinCustomerResponse> joinCustomer(

            @RequestBody JoinCustomerRequest joinCustomerRequest
            ){
        return ResponseEntity.ok(joinCustomerService.joinCustomer(joinCustomerRequest));

    }
}
