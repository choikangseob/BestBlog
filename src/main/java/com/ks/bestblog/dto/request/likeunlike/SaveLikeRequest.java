package com.ks.bestblog.dto.request.likeunlike;

public record SaveLikeRequest(
        long id,

        long articleId,

        long likes,

        long createMemberId
) {
}
