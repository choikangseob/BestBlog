package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveCategoryRepository extends JpaRepository<Category, Long> {


}
