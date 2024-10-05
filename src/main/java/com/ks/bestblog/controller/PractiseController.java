package com.ks.bestblog.controller;

import com.ks.bestblog.dto.response.PractiseExampleResponse;
import com.ks.bestblog.service.PractiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class PractiseController {
        private final PractiseService practiseService;


        @GetMapping("/practise/example/one")
        public PractiseExampleResponse getPractiseExampleOne(){
            return PractiseService.getPractiseExampleOne();
        }

}
