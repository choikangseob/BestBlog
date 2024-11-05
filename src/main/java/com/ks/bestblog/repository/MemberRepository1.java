package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Member1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository1 extends JpaRepository<Member1, Integer> {

    Optional<Member1> findByUsername(String username);
}
