package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeleteCategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);
    Optional<Category> findByIdAndCreateMemberId(Long id, Long createMemberId);
}
