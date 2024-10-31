package com.ks.bestblog.service;


import com.ks.bestblog.dto.request.JoinTotalpeopleRequest;
import com.ks.bestblog.dto.response.JoinTotalPeopleResponse;
import com.ks.bestblog.entity.Totalpeople;
import com.ks.bestblog.repository.JoinTotalpeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinTotalpeopleService {

    public final JoinTotalpeopleRepository joinTotalpeopleRepository;

    public JoinTotalPeopleResponse joinTotalpeople(JoinTotalpeopleRequest joinTotalpeopleRequest) {

        Totalpeople totalPeople = Totalpeople.from(joinTotalpeopleRequest);
        Totalpeople savedTotalpeople = joinTotalpeopleRepository.save(totalPeople);

        return JoinTotalPeopleResponse.of(savedTotalpeople);
    }
}
