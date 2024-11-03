package com.ks.bestblog.controller;

import com.ks.bestblog.dto.request.JoinRequest;
import com.ks.bestblog.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {


    private final JoinService joinService;

    public JoinController(JoinService joinService) {

        this.joinService = joinService;

    }
    @PostMapping("/join")
    public String joinProcess(
            @RequestBody JoinRequest joinRequest){

        joinService.joinProcess(joinRequest);

        return "ok";
    }
}
