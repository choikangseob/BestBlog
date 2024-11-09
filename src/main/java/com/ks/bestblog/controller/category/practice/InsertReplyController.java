package com.ks.bestblog.controller.category.practice;


import com.ks.bestblog.dto.request.practice.InsertReplyRequest;
import com.ks.bestblog.dto.response.practice.InsertReplyResponse;
import com.ks.bestblog.service.practice.InsertReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InsertReplyController {

    private final InsertReplyService insertReplyService;

    @PostMapping("/reply")
    public ResponseEntity<InsertReplyResponse> insertReply(

            @RequestBody InsertReplyRequest insertReplyRequest) {

        return ResponseEntity.ok(insertReplyService.insertReply(insertReplyRequest));
    }


}
