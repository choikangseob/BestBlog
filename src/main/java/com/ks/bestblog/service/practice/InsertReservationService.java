package com.ks.bestblog.service.practice;


import com.ks.bestblog.dto.request.practice.InsertReservationRequest;
import com.ks.bestblog.dto.response.practice.InsertReservationResponse;
import com.ks.bestblog.entity.practice.Reservation;
import com.ks.bestblog.repository.pratice.ReservationRepository;
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
