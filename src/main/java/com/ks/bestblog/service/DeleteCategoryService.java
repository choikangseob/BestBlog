package com.ks.bestblog.service;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.DeleteCategoryRequest;
import com.ks.bestblog.dto.response.DeleteCategoryResponse;
import com.ks.bestblog.entity.Category;
import com.ks.bestblog.repository.DeleteCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteCategoryService {

    private final DeleteCategoryRepository deleteCategoryRepository;



    public DeleteCategoryResponse deleteCategory(DeleteCategoryRequest deleteCategoryRequest, MemberDetails member) {

        Optional<Category> deleteByCreateMemberId = deleteCategoryRepository.findByIdAndCreateMemberId(deleteCategoryRequest.id(), member.getId());

        Category categoryDelete = deleteByCreateMemberId.orElseThrow(() -> new RuntimeException("결과값이 없습니다"));

        deleteCategoryRepository.delete(categoryDelete);

        return DeleteCategoryResponse.of(categoryDelete);
    }
}
