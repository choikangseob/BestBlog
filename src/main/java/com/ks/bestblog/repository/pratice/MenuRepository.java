package com.ks.bestblog.repository.pratice;

import com.ks.bestblog.entity.practice.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Optional<Menu> findByMenuname(String menuName);
}
