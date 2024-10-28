package com.ks.bestblog.dto.response;

import com.ks.bestblog.entity.Reply;
import lombok.Builder;

@Builder
public record InsertReplyResponse(
        int id,
        String comment,
        String uid
) {
    public static InsertReplyResponse of(Reply savedReply){
        return InsertReplyResponse.builder()
                .id(savedReply.getId())
                .comment(savedReply.getComment())
                .uid(savedReply.getUid())
                .build();
    }
}
