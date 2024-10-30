package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Customer;
import lombok.Builder;

@Builder
public record JoinCustomerResponse(
        int id,
        String name,
        int phonenumber
) {
    public static JoinCustomerResponse of(Customer SavedCustomer) {
    return JoinCustomerResponse.builder()
            .id(SavedCustomer.getId())
            .name(SavedCustomer.getName())
            .phonenumber(SavedCustomer.getPhonenumber())
            .build();
}
}
