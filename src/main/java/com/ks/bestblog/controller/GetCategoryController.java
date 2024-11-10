package com.ks.bestblog.controller;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.CategoryResponse;
import com.ks.bestblog.service.GetCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetCategoryController {

    private final GetCategoryService getCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getCategories(
            @AuthenticationPrincipal MemberDetails member
    ){
        return ResponseEntity.ok(getCategoryService.getCategoriesByMember(member));
    }
}
