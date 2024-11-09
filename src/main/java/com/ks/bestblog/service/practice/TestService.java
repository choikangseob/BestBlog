package com.ks.bestblog.service.practice;

import com.ks.bestblog.dto.request.practice.TestRequest;
import com.ks.bestblog.dto.response.practice.TestResponse;
import com.ks.bestblog.entity.practice.Test;
import com.ks.bestblog.repository.pratice.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    public final TestRepository testRepository;

    public TestResponse test(TestRequest testRequest){

        Test test = Test.from(testRequest);
        Test savedTest = testRepository.save(test);
        return TestResponse.of(savedTest);
    }
}
