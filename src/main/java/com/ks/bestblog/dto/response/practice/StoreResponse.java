package com.ks.bestblog.dto.response.practice;

import com.ks.bestblog.entity.practice.Store;
import lombok.Builder;

@Builder
public record StoreResponse(
        int id,
        String goodsname,
        int price
) {
    public static StoreResponse of(Store savedStore) {
            return StoreResponse.builder()
                    .id(savedStore.getId())
                    .goodsname(savedStore.getGoodsname())
                    .price(savedStore.getPrice())
                    .build();
    }
}
