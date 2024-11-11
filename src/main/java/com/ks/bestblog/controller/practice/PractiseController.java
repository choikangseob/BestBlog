package com.ks.bestblog.controller.practice;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.practice.PractiseExampleResponse;
import com.ks.bestblog.service.practice.PractiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class PractiseController {


        private final PractiseService practiseService;


        @GetMapping("/practise/example/one")
        public PractiseExampleResponse getPractiseExampleOne(
                @AuthenticationPrincipal MemberDetails member
        ){
            log.info("member id ={}", member.getId());
            return PractiseService.getPractiseExampleOne();
        }

}
