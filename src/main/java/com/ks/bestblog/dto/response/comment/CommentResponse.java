package com.ks.bestblog.dto.response.comment;

import com.ks.bestblog.entity.Comment;
import lombok.Builder;

@Builder
public record CommentResponse(
        long id,

        long articleId,

        long depth,

        long parentId,

        String Comment

) {
    public static CommentResponse of(com.ks.bestblog.entity.Comment savedComment){

        return CommentResponse.builder()
                .id(savedComment.getId())
                .articleId(savedComment.getArticleId())
                .depth(savedComment.getDepth())
                .parentId(savedComment.getParentId())
                .Comment(savedComment.getComment())
                .build();
    }
}
