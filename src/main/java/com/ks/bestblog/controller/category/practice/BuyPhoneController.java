package com.ks.bestblog.controller.category.practice;

import com.ks.bestblog.dto.request.practice.BuyPhoneRequest;
import com.ks.bestblog.dto.response.practice.BuyPhoneResponse;
import com.ks.bestblog.service.practice.BuyPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BuyPhoneController {

    public final BuyPhoneService buyPhoneService;
    @PostMapping("/phone")
    public ResponseEntity<BuyPhoneResponse> buyPhone(
            @RequestBody BuyPhoneRequest buyPhoneRequest) {
        return ResponseEntity.ok(buyPhoneService.buyPhone(buyPhoneRequest));
    }
}
