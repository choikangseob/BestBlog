package com.ks.bestblog.controller.practice;


import com.ks.bestblog.dto.request.practice.TurnonCarRequest;
import com.ks.bestblog.dto.response.practice.TurnonResponse;
import com.ks.bestblog.service.practice.TurnonCarService;
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
