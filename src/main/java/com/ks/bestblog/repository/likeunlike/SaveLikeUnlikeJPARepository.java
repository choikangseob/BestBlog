package com.ks.bestblog.repository.likeunlike;

import com.ks.bestblog.entity.Likeunlike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaveLikeUnlikeJPARepository extends JpaRepository<Likeunlike, Long> {

 Optional<Likeunlike> findByCreateMemberId(Long createMemberId);

}
