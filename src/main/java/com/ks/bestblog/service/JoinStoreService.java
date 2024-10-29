package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.JoinStoreRequest;
import com.ks.bestblog.dto.response.StoreResponse;
import com.ks.bestblog.entity.Store;
import com.ks.bestblog.repository.JoinStoreRepository;
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
