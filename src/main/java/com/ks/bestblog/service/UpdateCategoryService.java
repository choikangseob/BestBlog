package com.ks.bestblog.service;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.UpdateCategoryRequest;
import com.ks.bestblog.dto.response.UpdateCategoryResponse;
import com.ks.bestblog.entity.Category;
import com.ks.bestblog.repository.UpdateCategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateCategoryService {

    private final UpdateCategoryRepository updateCategoryRepository;



    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest, MemberDetails member) {


        Optional<Category> categoryOptional = updateCategoryRepository.findByIdAndCreateMemberId(updateCategoryRequest.id(),member.getId());
        Category category = categoryOptional.orElseThrow(() -> new RuntimeException("결과값이 없습니다"));


        category.setDepth(updateCategoryRequest.depth());
        category.setTitle(updateCategoryRequest.title());

        return UpdateCategoryResponse.of(category);

    }
}
