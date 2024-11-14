package com.ks.bestblog.service.likeunlike;


import com.ks.bestblog.dto.request.likeunlike.SaveLikesDislikeRequest;
import com.ks.bestblog.dto.response.likeunlike.LikesDislikeResponse;
import com.ks.bestblog.entity.Likesdislike;
import com.ks.bestblog.repository.likeunlike.SaveLikeUnlikeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaveLikesDislikeService {

    private final SaveLikeUnlikeJPARepository saveLikeUnlikeJPARepository;

    public LikesDislikeResponse saveLikesDislike(SaveLikesDislikeRequest saveLikesDislikeRequest, SelectType selectType){

        switch (selectType){

            case LIKE:
                
                
                    Likesdislike saveLikes = Likesdislike.from(saveLikesDislikeRequest);
                Optional<Likesdislike> existingLikes = saveLikeUnlikeJPARepository.findById(saveLikesDislikeRequest.getId());
                if(existingLikes.isPresent() && existingLikes.get().getLikes() == 0 && existingLikes.get().getDislike() == 0) {
                    saveLikes.setLikes(saveLikes.getLikes() + 1);
                    Likesdislike savedLikes = saveLikeUnlikeJPARepository.save(saveLikes);

                    return LikesDislikeResponse.of(savedLikes);
                }else{
                    System.out.println("좋아요나 싫어요를  눌렀던 게시글 입니다");
                    return null;
                }
            case DISLIKE:
                Likesdislike saveDislike = Likesdislike.from(saveLikesDislikeRequest);
                Optional<Likesdislike> existingDislike = saveLikeUnlikeJPARepository.findById(saveLikesDislikeRequest.getId());
                if(existingDislike.isPresent() && existingDislike.get().getDislike() == 0 && existingDislike.get().getLikes() == 0) {
                    saveDislike.setDislike(saveDislike.getDislike() + 1);
                    Likesdislike savedDislike = saveLikeUnlikeJPARepository.save(saveDislike);

                    return LikesDislikeResponse.of(savedDislike);
                }else{
                    System.out.println("싫어요나 좋아요를  눌렀던 게시글 입니다");
                    return null;
                }
            default:
                return null;


        }


    }

    public enum SelectType {
        LIKE, DISLIKE;
    }
}
