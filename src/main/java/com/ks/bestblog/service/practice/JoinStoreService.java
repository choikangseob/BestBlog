package com.ks.bestblog.service.practice;

import com.ks.bestblog.dto.request.practice.JoinStoreRequest;
import com.ks.bestblog.dto.response.practice.StoreResponse;
import com.ks.bestblog.entity.practice.Store;
import com.ks.bestblog.repository.pratice.JoinStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinStoreService {
    private final JoinStoreRepository joinStoreRepository;

    public StoreResponse joinStore(JoinStoreRequest joinStoreRequest) {

        Store joinStore = Store.from(joinStoreRequest);
        Store savedStore = joinStoreRepository.save(joinStore);
        return StoreResponse.of(savedStore);
    }
}
