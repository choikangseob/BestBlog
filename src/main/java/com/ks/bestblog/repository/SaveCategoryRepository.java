package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaveCategoryRepository extends JpaRepository<Category, Long> {


}
