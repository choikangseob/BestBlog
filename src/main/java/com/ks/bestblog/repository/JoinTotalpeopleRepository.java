package com.ks.bestblog.repository;


import com.ks.bestblog.entity.Totalpeople;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoinTotalpeopleRepository extends JpaRepository<Totalpeople, Integer> {
    Optional<Totalpeople> findByTotalpeople(int totalPeople);
}
