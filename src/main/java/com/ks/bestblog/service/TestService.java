package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.TestRequest;
import com.ks.bestblog.dto.response.TestResponse;
import com.ks.bestblog.entity.Test;
import com.ks.bestblog.repository.TestRepository;
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
