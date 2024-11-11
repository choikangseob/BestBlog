package com.ks.bestblog.repository.category;

import com.ks.bestblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UpdateCategoryJPARepository extends JpaRepository<Category, Long> {



    Optional<Category> findById(long id);
    Optional<Category> findByIdAndCreateMemberId(long id , Long memberId );
}
