package com.ks.bestblog.dto.request;

public record InsertReplyRequest(
        String comment,
        String uid
) {
}
