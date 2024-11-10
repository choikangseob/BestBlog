package com.ks.bestblog.service;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.DeleteCategoryRequest;
import com.ks.bestblog.dto.response.DeleteCategoryResponse;
import com.ks.bestblog.entity.Category;
import com.ks.bestblog.repository.DeleteCategoryJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteCategoryService {

    private final DeleteCategoryJPARepository deleteCategoryJPARepository;



    public DeleteCategoryResponse deleteCategory(DeleteCategoryRequest deleteCategoryRequest, MemberDetails member) {

        Optional<Category> categoryOptional = deleteCategoryJPARepository.findByIdAndCreateMemberId(deleteCategoryRequest.id(), member.getId());

        Category categoryTobeDeleted = categoryOptional.orElseThrow(() -> new RuntimeException("결과값이 없습니다"));

        deleteCategoryJPARepository.delete(categoryTobeDeleted);

        return DeleteCategoryResponse.of(categoryTobeDeleted);
    }
}
