package com.ks.bestblog.repository.likeunlike;

import com.ks.bestblog.entity.Likesdislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveLikesDislikeJPARepository extends JpaRepository<Likesdislike, Long> {


}
