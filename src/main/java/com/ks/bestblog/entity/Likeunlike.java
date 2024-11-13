package com.ks.bestblog.entity;

import com.ks.bestblog.common.entity.EssentialColumns;
import com.ks.bestblog.dto.request.likeunlike.SaveLikeRequest;
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
public class Likeunlike extends EssentialColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long articleId;

    private long likes;

    private long dislike;

    private long createMemberId;

    public static Likeunlike from(SaveLikeRequest   saveLikeRequest){

        return new Likeunlike(saveLikeRequest);
    }

    public Likeunlike(SaveLikeRequest saveLikeRequest) {
        this.articleId = saveLikeRequest.articleId();
        this.likes = saveLikeRequest.likes();
        this.createMemberId = saveLikeRequest.createMemberId();


    }

}
