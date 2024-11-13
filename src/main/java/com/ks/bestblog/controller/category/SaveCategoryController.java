package com.ks.bestblog.controller.category;


import com.ks.bestblog.dto.request.category.SaveCategoryRequest;
import com.ks.bestblog.dto.response.category.CategoryResponse;
import com.ks.bestblog.service.category.SaveCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SaveCategoryController {

    private final SaveCategoryService saveCategoryService;

    @PostMapping("/saveCategory")
    public ResponseEntity<CategoryResponse> saveCategory(
            @RequestBody SaveCategoryRequest saveCategoryRequest
    ) {

        return ResponseEntity.ok(saveCategoryService.saveCategory(saveCategoryRequest));
    }
}
