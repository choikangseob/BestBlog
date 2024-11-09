package com.ks.bestblog.controller.category.practice;

import com.ks.bestblog.dto.request.practice.JoinTotalpeopleRequest;
import com.ks.bestblog.dto.response.practice.JoinTotalPeopleResponse;
import com.ks.bestblog.service.practice.JoinTotalpeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinTotalPeopleController {

    public final JoinTotalpeopleService joinTotalpeopleService;

    @PostMapping("/totalpeople")
    public ResponseEntity<JoinTotalPeopleResponse> joinTotalPeople(
            @RequestBody JoinTotalpeopleRequest joinTotalPeopleRequest
    ){
        return ResponseEntity.ok(joinTotalpeopleService.joinTotalpeople(joinTotalPeopleRequest));
    }
}
