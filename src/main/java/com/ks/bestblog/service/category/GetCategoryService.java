package com.ks.bestblog.service.category;


import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.category.CategoryResponse;
import com.ks.bestblog.repository.category.CategoryMybatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCategoryService {

    private final CategoryMybatisRepository categoryMybatisRepository;

    public List<CategoryResponse> getCategoriesByMember(MemberDetails member) {



        return categoryMybatisRepository.findAllByMemberId(member.getId());
    }
}
