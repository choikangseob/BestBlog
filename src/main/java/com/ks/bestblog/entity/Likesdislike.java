package com.ks.bestblog.entity;

import com.ks.bestblog.common.entity.EssentialColumns;
import com.ks.bestblog.dto.request.likeunlike.SaveLikesDislikeRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Likesdislike extends EssentialColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long articleId;

    private long likes;

    private long dislike;

    private long createMemberId;

    private String type;

    public static Likesdislike from(SaveLikesDislikeRequest saveLikesDislikeRequest){

        return new Likesdislike(saveLikesDislikeRequest);
    }

    public Likesdislike(SaveLikesDislikeRequest saveLikesDislikeRequest) {
        this.articleId = saveLikesDislikeRequest.articleId();
        this.likes = saveLikesDislikeRequest.likes();
        this.dislike = saveLikesDislikeRequest.dislikes();
        this.createMemberId = saveLikesDislikeRequest.createMemberId();
        this.type = saveLikesDislikeRequest.type();


    }

}
