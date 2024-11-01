package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
