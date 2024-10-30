package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoinCustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByName(String name);
}
