package com.ks.bestblog.service.practice;

import com.ks.bestblog.dto.request.practice.JoinDeliveryRequest;
import com.ks.bestblog.dto.response.practice.JoinDeliveryResponse;
import com.ks.bestblog.entity.practice.Delivery;
import com.ks.bestblog.repository.pratice.JoinDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinDeliveryService {

    public final JoinDeliveryRepository joinDeliveryRepository;

    public JoinDeliveryResponse joinDelivery(JoinDeliveryRequest joinDeliveryRequest){

        Delivery joinDelivery = Delivery.from(joinDeliveryRequest);
        Delivery savedDelivery = joinDeliveryRepository.save(joinDelivery);
        return JoinDeliveryResponse.of(savedDelivery);
    }
}
