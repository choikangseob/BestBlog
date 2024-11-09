package com.ks.bestblog.service.practice;

import com.ks.bestblog.dto.request.practice.TurnonCarRequest;
import com.ks.bestblog.dto.response.practice.TurnonResponse;
import com.ks.bestblog.entity.practice.Car;
import com.ks.bestblog.repository.pratice.TurnonCarRepository;
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
