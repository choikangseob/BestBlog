package com.ks.bestblog.controller.category;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.UpdateCategoryRequest;
import com.ks.bestblog.dto.response.UpdateCategoryResponse;
import com.ks.bestblog.service.UpdateCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateCategoryController {

    private final UpdateCategoryService updateCategoryService;

    @PostMapping("/updateCategory")

    public ResponseEntity<UpdateCategoryResponse> updateCategory(
            @RequestBody UpdateCategoryRequest updateCategoryRequest,
            @AuthenticationPrincipal MemberDetails member
            ){

        return ResponseEntity.ok(updateCategoryService.updateCategory(updateCategoryRequest,member));
    }
}
