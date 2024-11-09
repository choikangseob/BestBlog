package com.ks.bestblog.controller;


import com.ks.bestblog.dto.request.TurnonCarRequest;
import com.ks.bestblog.dto.response.TurnonResponse;
import com.ks.bestblog.service.TurnonCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TurnonCarController {
    public final TurnonCarService turnonCarService;
    @PostMapping("/turnoncar")
    public ResponseEntity<TurnonResponse> turnonResponse(

            @RequestBody TurnonCarRequest turnonCarRequest
    ){
        return ResponseEntity.ok(turnonCarService.turnonResponse(turnonCarRequest));
    }
}
