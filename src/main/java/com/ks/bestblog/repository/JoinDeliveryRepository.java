package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinDeliveryRepository extends JpaRepository<Delivery, Integer> {
}
