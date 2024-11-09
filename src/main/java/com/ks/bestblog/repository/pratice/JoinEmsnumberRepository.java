package com.ks.bestblog.repository.pratice;

import com.ks.bestblog.entity.practice.Emsnumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoinEmsnumberRepository extends JpaRepository<Emsnumber, Integer> {
    Optional<Emsnumber> findByDepartment(String department);
}
