package com.ks.bestblog.repository.pratice;

import com.ks.bestblog.entity.practice.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyPhoneRepository extends JpaRepository<Phone, Integer> {
    Optional<Phone> findByModel(String model);
}
