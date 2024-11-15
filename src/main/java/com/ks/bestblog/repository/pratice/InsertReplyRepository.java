package com.ks.bestblog.repository.pratice;

import com.ks.bestblog.entity.practice.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsertReplyRepository extends JpaRepository<Reply, Integer> {

    Optional<Reply> findByUid(String uid);
}
