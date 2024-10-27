package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinMemberRepository extends JpaRepository<Member,Long> {
}
