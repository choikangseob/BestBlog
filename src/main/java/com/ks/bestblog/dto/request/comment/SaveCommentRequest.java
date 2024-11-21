package com.ks.bestblog.dto.request.comment;

public record SaveCommentRequest(
        long id,

        long articleId,

        long depth,

        long parentId,

        String comment
) {
}
