package com.ks.bestblog.repository.pratice;

import com.ks.bestblog.entity.practice.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoinStoreRepository extends JpaRepository<Store, Integer> {
    Optional<Store> findByGoodsname(String goodsname);
}
