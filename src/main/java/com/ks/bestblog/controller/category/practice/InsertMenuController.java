package com.ks.bestblog.controller.category.practice;

import com.ks.bestblog.dto.request.practice.InsertMenuRequest;
import com.ks.bestblog.dto.response.practice.InsertMenuResponse;
import com.ks.bestblog.service.practice.InsertMenuService;
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
