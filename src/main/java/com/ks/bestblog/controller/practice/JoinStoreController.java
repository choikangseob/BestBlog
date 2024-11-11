package com.ks.bestblog.controller.practice;

import com.ks.bestblog.dto.request.practice.JoinStoreRequest;
import com.ks.bestblog.dto.response.practice.StoreResponse;
import com.ks.bestblog.service.practice.JoinStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinStoreController {
    private final JoinStoreService joinStoreService;

    @PostMapping("/store")
    public ResponseEntity<StoreResponse> joinStore(
       @RequestBody JoinStoreRequest joinStoreRequest
    ){
        return ResponseEntity.ok(joinStoreService.joinStore(joinStoreRequest));
    }
}
