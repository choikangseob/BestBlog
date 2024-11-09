package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UpdateCategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(long id);

}
