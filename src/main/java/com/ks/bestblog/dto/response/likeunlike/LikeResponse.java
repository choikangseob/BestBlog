package com.ks.bestblog.dto.response.likeunlike;


import com.ks.bestblog.entity.Likeunlike;
import lombok.Builder;

@Builder
public record LikeResponse(
        long id,

        long articleId,

        long likes,

        long createMemberId
) {

    public static LikeResponse of(Likeunlike outofsavedLike) {

        return LikeResponse.builder()
                .id(outofsavedLike.getId())
                .articleId(outofsavedLike.getArticleId())
                .likes(outofsavedLike.getLikes())
                .createMemberId(outofsavedLike.getCreateMemberId())
                .build();

    }
}
