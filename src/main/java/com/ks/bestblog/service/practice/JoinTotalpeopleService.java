package com.ks.bestblog.service.practice;


import com.ks.bestblog.dto.request.practice.JoinTotalpeopleRequest;
import com.ks.bestblog.dto.response.practice.JoinTotalPeopleResponse;
import com.ks.bestblog.entity.practice.Totalpeople;
import com.ks.bestblog.repository.pratice.JoinTotalpeopleRepository;
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
