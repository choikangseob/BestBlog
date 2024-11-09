package com.ks.bestblog.controller.httpFiles;

import com.ks.bestblog.dto.request.UpdateCategoryRequest;
import com.ks.bestblog.dto.response.UpdateCategoryResponse;
import com.ks.bestblog.service.UpdateCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateCategoryController {

    private final UpdateCategoryService updateCategoryService;

    @PostMapping("/updateCategory")
    public ResponseEntity<UpdateCategoryResponse> updateCategory(
            @RequestBody UpdateCategoryRequest updateCategoryRequest
            ){

        return ResponseEntity.ok(updateCategoryService.updateCategory(updateCategoryRequest));
    }
}
