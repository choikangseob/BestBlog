package com.ks.bestblog.repository.category;

import com.ks.bestblog.dto.response.category.CategoryResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMybatisRepository {

    List<CategoryResponse> findAllByMemberId(Long memberId);

}
