package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.SaveCategoryRequest;
import com.ks.bestblog.dto.response.CategoryResponse;
import com.ks.bestblog.entity.Category;
import com.ks.bestblog.repository.SaveCategoryJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCategoryService {

    public final SaveCategoryJPARepository saveCategoryJPARepository;

    public CategoryResponse saveCategory(SaveCategoryRequest saveCategoryRequest){

        Category category = Category.from(saveCategoryRequest);
        Category savedCategory = saveCategoryJPARepository.save(category);

        return CategoryResponse.of(savedCategory);
    }
}
