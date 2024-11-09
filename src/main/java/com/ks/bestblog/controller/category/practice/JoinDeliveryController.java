package com.ks.bestblog.controller.category.practice;

import com.ks.bestblog.dto.request.practice.JoinDeliveryRequest;
import com.ks.bestblog.dto.response.practice.JoinDeliveryResponse;
import com.ks.bestblog.service.practice.JoinDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinDeliveryController {

    private final JoinDeliveryService joinDeliveryService;

    @PostMapping("/delivery")
    public ResponseEntity<JoinDeliveryResponse> joinDelivery(
            @RequestBody JoinDeliveryRequest joinDeliveryRequest
    ){
        return ResponseEntity.ok(joinDeliveryService.joinDelivery(joinDeliveryRequest));
    }
}
