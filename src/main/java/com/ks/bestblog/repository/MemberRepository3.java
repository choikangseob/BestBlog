package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Member3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository3 extends JpaRepository<Member3, Integer> {

    Optional<Member3> findByEmail(String email);

}
