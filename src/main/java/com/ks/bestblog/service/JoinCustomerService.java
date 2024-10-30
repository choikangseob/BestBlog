package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.JoinCustomerRequest;
import com.ks.bestblog.dto.response.JoinCustomerResponse;
import com.ks.bestblog.entity.Customer;
import com.ks.bestblog.repository.JoinCustomerRepository;
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
