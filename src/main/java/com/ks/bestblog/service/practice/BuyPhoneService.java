package com.ks.bestblog.service.practice;

import com.ks.bestblog.dto.request.practice.BuyPhoneRequest;
import com.ks.bestblog.dto.response.practice.BuyPhoneResponse;
import com.ks.bestblog.entity.practice.Phone;
import com.ks.bestblog.repository.pratice.BuyPhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyPhoneService {

    public final BuyPhoneRepository buyPhoneRepository;

    public BuyPhoneResponse buyPhone(BuyPhoneRequest buyPhoneRequest) {
        Phone buyphone = Phone.from(buyPhoneRequest);
        Phone savedPhone = buyPhoneRepository.save(buyphone);
        return BuyPhoneResponse.of(savedPhone);
    }
}
