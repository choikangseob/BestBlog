package com.ks.bestblog.service.practice;


import com.ks.bestblog.dto.request.practice.JoinEmsnumberRequest;
import com.ks.bestblog.dto.response.practice.JoinEmsnumberResponse;
import com.ks.bestblog.entity.practice.Emsnumber;
import com.ks.bestblog.repository.pratice.JoinEmsnumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinEmsnumberService {
    public final JoinEmsnumberRepository joinEmsnumberRepository;

            public JoinEmsnumberResponse joinEmsnumber(JoinEmsnumberRequest joinEmsnumberRequest) {

                Emsnumber joinEmsnumber = Emsnumber.from(joinEmsnumberRequest);
                Emsnumber savedEmsnumber = joinEmsnumberRepository.save(joinEmsnumber);
                return JoinEmsnumberResponse.of(savedEmsnumber);

            }

}
