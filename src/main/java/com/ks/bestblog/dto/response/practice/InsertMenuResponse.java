package com.ks.bestblog.dto.response.practice;


import com.ks.bestblog.entity.practice.Menu;
import lombok.Builder;

@Builder
public record InsertMenuResponse(
        int id,
        String menuname,
        int price
) {
    public static InsertMenuResponse of(Menu savedMenu){
        return InsertMenuResponse.builder()
                .id(savedMenu.getId())
                .menuname(savedMenu.getMenuname())
                .price(savedMenu.getPrice())
                .build();
    }
}


