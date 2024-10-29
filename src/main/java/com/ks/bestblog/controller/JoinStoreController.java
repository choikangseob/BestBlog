package com.ks.bestblog.controller;

import com.ks.bestblog.dto.request.JoinStoreRequest;
import com.ks.bestblog.dto.response.StoreResponse;
import com.ks.bestblog.service.JoinStoreService;
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
