package com.ks.bestblog.controller.category.practice;

import com.ks.bestblog.dto.request.practice.JoinCustomerRequest;
import com.ks.bestblog.dto.response.practice.JoinCustomerResponse;
import com.ks.bestblog.service.practice.JoinCustomerService;
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
