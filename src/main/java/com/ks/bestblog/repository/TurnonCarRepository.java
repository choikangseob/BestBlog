package com.ks.bestblog.repository;

import com.ks.bestblog.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurnonCarRepository extends JpaRepository<Car,Integer> {
Optional<Car> findCarByModel(String model);
}
