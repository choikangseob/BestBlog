package com.ks.bestblog.repository.member;

import com.ks.bestblog.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UpdateMemberJPARepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(long id);
}
