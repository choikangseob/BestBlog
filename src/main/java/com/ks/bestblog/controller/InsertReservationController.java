package com.ks.bestblog.controller;


import com.ks.bestblog.dto.request.InsertReservationRequest;
import com.ks.bestblog.dto.response.InsertReservationResponse;
import com.ks.bestblog.entity.Reservation;
import com.ks.bestblog.repository.ReservationRepository;
import com.ks.bestblog.service.InsertReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InsertReservationController {
    private final InsertReservationService insertReservationService;

    @PostMapping("/reservation")
    public ResponseEntity<InsertReservationResponse> insertReservation(
            @RequestBody InsertReservationRequest insertReservationRequest) {

        return ResponseEntity.ok(insertReservationService.insertReservation(insertReservationRequest));
    }

}
