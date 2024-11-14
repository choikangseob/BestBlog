package com.ks.bestblog.dto.request.likeunlike;


public record SaveLikesDislikeRequest(
        long id,

        long articleId,

        long likes,

        long dislikes,

        long createMemberId,

        String type
) {
    public Long getId() {
        return id;
    }
}
