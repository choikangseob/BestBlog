package com.ks.bestblog.repository.likeunlike;

import com.ks.bestblog.entity.Likesdislike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaveLikesDislikeJPARepository extends JpaRepository<Likesdislike, Long> {


    Optional<Likesdislike> findByArticleIdAndCreateMemberId(long articleId, long createMemberId);
}
