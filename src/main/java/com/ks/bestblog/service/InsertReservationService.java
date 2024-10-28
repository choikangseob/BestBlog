package com.ks.bestblog.service;


import com.ks.bestblog.dto.request.InsertReservationRequest;
import com.ks.bestblog.dto.response.InsertReservationResponse;
import com.ks.bestblog.entity.Reservation;
import com.ks.bestblog.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsertReservationService {
    private final ReservationRepository reservationRepository;

    public InsertReservationResponse insertReservation(InsertReservationRequest insertReservationRequest) {

        Reservation reservation = Reservation.from(insertReservationRequest);
        Reservation savedReservation = reservationRepository.save(reservation);
        return InsertReservationResponse.of(savedReservation);
    }
}
