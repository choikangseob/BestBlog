package com.ks.bestblog.controller.practice;


import com.ks.bestblog.dto.request.practice.InsertReservationRequest;
import com.ks.bestblog.dto.response.practice.InsertReservationResponse;
import com.ks.bestblog.service.practice.InsertReservationService;
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
