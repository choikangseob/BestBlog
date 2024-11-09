package com.ks.bestblog.repository.pratice;

import com.ks.bestblog.entity.practice.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurnonCarRepository extends JpaRepository<Car,Integer> {
Optional<Car> findCarByModel(String model);
}
