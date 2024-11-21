package com.ks.bestblog.dto.response.comment;

import com.ks.bestblog.entity.Comment;
import lombok.Builder;


@Builder
public record DeleteCommentResponse(
        long id
) {

    public static DeleteCommentResponse of(Comment deleteComment) {

        return DeleteCommentResponse.builder()
                .id(deleteComment.getId())
                .build();
    }
}
