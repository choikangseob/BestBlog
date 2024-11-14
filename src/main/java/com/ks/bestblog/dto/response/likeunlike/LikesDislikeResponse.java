package com.ks.bestblog.dto.response.likeunlike;


import com.ks.bestblog.entity.Likesdislike;
import lombok.Builder;

@Builder
public record LikesDislikeResponse(
        long id,

        long articleId,

        long likes,

        long dislike,

        long createMemberId,

        String type
) {

    public static LikesDislikeResponse of(Likesdislike outOfSavedLike) {

        return LikesDislikeResponse.builder()
                .id(outOfSavedLike.getId())
                .articleId(outOfSavedLike.getArticleId())
                .likes(outOfSavedLike.getLikes())
                .dislike(outOfSavedLike.getDislike())
                .createMemberId(outOfSavedLike.getCreateMemberId())
                .type(outOfSavedLike.getType())
                .build();

    }
}
