package com.ks.bestblog.service.practice;

import com.ks.bestblog.dto.request.practice.JoinCustomerRequest;
import com.ks.bestblog.dto.response.practice.JoinCustomerResponse;
import com.ks.bestblog.entity.practice.Customer;
import com.ks.bestblog.repository.pratice.JoinCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinCustomerService {
    public final JoinCustomerRepository joinCustomerRepository;

    public JoinCustomerResponse joinCustomer(JoinCustomerRequest joinCustomerRequest) {

       Customer joinCustomer = Customer.from(joinCustomerRequest);
       Customer savedCustomer = joinCustomerRepository.save(joinCustomer);
       return JoinCustomerResponse.of(savedCustomer);
    }
}
