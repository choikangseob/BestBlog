package com.ks.bestblog.controller.category;


import com.ks.bestblog.dto.request.SaveCategoryRequest;
import com.ks.bestblog.dto.response.ResponseCategory;
import com.ks.bestblog.service.SaveCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SaveCategoryController {

    private final SaveCategoryService saveCategoryService;

    @PostMapping("/category")
    public ResponseEntity<ResponseCategory> saveCategory(
            @RequestBody SaveCategoryRequest saveCategoryRequest
    ) {

        return ResponseEntity.ok(saveCategoryService.saveCategory(saveCategoryRequest));
    }
}
