package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.SaveCategoryRequest;
import com.ks.bestblog.dto.response.ResponseCategory;
import com.ks.bestblog.entity.Category;
import com.ks.bestblog.repository.SaveCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCategoryService {

    public final SaveCategoryRepository saveCategoryRepository;

    public ResponseCategory saveCategory(SaveCategoryRequest saveCategoryRequest){

        Category category = Category.from(saveCategoryRequest);
        Category savedCategory = saveCategoryRepository.save(category);

        return ResponseCategory.of(savedCategory);
    }
}
