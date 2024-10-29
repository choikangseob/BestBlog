package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoinStoreRepository extends JpaRepository<Store, Integer> {
    Optional<Store> findByGoodsname(String goodsname);
}
