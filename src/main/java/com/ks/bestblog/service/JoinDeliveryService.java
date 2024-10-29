package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.JoinDeliveryRequest;
import com.ks.bestblog.dto.response.JoinDeliveryResponse;
import com.ks.bestblog.entity.Delivery;
import com.ks.bestblog.repository.JoinDeliveryRepository;
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
