package com.ks.bestblog.service;


import com.ks.bestblog.dto.request.JoinEmsnumberRequest;
import com.ks.bestblog.dto.response.JoinEmsnumberResponse;
import com.ks.bestblog.entity.Emsnumber;
import com.ks.bestblog.repository.JoinEmsnumberRepository;
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
