package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.BuyPhoneRequest;
import com.ks.bestblog.dto.response.BuyPhoneResponse;
import com.ks.bestblog.entity.Phone;
import com.ks.bestblog.repository.BuyPhoneRepository;
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
