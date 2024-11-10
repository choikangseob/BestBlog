package com.ks.bestblog.controller;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.DeleteCategoryRequest;
import com.ks.bestblog.dto.response.DeleteCategoryResponse;
import com.ks.bestblog.service.DeleteCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteCategoryController {

    private final DeleteCategoryService deleteCategoryService;
    @PostMapping("/deleteCategory")
    public ResponseEntity<DeleteCategoryResponse> deleteCategory(
            @RequestBody DeleteCategoryRequest deleteCategoryRequest,
            @AuthenticationPrincipal MemberDetails member
    ){
        return ResponseEntity.ok(deleteCategoryService.deleteCategory(deleteCategoryRequest,member));
    }

}
