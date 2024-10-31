package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.TurnonCarRequest;
import com.ks.bestblog.dto.response.TurnonResponse;
import com.ks.bestblog.entity.Car;
import com.ks.bestblog.repository.TurnonCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TurnonCarService {
   public final TurnonCarRepository turnoncarRepository;
    public TurnonResponse turnonResponse(TurnonCarRequest turnonCarRequest){
        Car turnoncar = Car.from(turnonCarRequest);
        Car savedCar= turnoncarRepository.save(turnoncar);

        return TurnonResponse.of(savedCar);

    }
}
