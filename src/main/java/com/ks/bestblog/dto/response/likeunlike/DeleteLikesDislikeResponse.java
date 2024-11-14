package com.ks.bestblog.dto.response.likeunlike;


import com.ks.bestblog.dto.request.likeunlike.DeleteLikesDislikeRequest;
import com.ks.bestblog.entity.Likesdislike;
import lombok.Builder;

@Builder
public record DeleteLikesDislikeResponse(
        long id
) {

    public static DeleteLikesDislikeResponse of(Likesdislike deletelikesdislike) {

        return DeleteLikesDislikeResponse.builder()
                .id(deletelikesdislike.getId())
                .build();
    }
}
