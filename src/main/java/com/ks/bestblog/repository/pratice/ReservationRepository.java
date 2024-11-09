package com.ks.bestblog.repository.pratice;

import com.ks.bestblog.entity.practice.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Integer > {

    Optional<Reservation> findByRoomname(String roomname);
}
