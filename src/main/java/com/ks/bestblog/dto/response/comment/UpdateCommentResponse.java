package com.ks.bestblog.dto.response.comment;

import com.ks.bestblog.entity.Comment;
import lombok.Builder;

@Builder
public record UpdateCommentResponse(
        long id,

        long articleId,

        long depth,

        long parentId,

        String comment
) {

    public static UpdateCommentResponse of(Comment updateComment){

        return UpdateCommentResponse.builder()
                .id(updateComment.getId())
                .articleId(updateComment.getArticleId())
                .depth(updateComment.getDepth())
                .parentId(updateComment.getParentId())
                .comment(updateComment.getComment())
                .build();
    }
}
