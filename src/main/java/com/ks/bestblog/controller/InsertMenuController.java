package com.ks.bestblog.controller;

import com.ks.bestblog.dto.request.InsertMenuRequest;
import com.ks.bestblog.dto.response.InsertMenuResponse;
import com.ks.bestblog.service.InsertMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
public class InsertMenuController {
    private final InsertMenuService insertMenuService;

    @PostMapping("/menu")
    public ResponseEntity<InsertMenuResponse> insertMenu(

            @RequestBody InsertMenuRequest insertMenuRequest
    ) {

    return ResponseEntity.ok(insertMenuService.insertMenu(insertMenuRequest));
    }
}
