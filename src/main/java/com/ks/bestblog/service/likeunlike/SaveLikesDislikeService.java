package com.ks.bestblog.service.likeunlike;


import com.ks.bestblog.dto.request.likeunlike.SaveLikesDislikeRequest;
import com.ks.bestblog.dto.response.likeunlike.LikesDislikeResponse;
import com.ks.bestblog.entity.Likesdislike;
import com.ks.bestblog.repository.likeunlike.SaveLikesDislikeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaveLikesDislikeService {

    private final SaveLikesDislikeJPARepository saveLikesDislikeJPARepository;

    public LikesDislikeResponse saveLikesDislike(SaveLikesDislikeRequest saveLikesDislikeRequest, SelectType selectType){

        switch (selectType){

            case LIKE:

                Optional<Likesdislike> existingLikes = saveLikesDislikeJPARepository.findByArticleIdAndCreateMemberId(saveLikesDislikeRequest.articleId(),saveLikesDislikeRequest.createMemberId());

                if (existingLikes.isEmpty() || (existingLikes.isPresent() && existingLikes.get().getDislike() == 0 && existingLikes.get().getLikes() == 0)) {
                    Likesdislike saveLikes;

                    if (existingLikes.isPresent()) {
                        return null;
                    } else {
                        saveLikes = Likesdislike.from(saveLikesDislikeRequest);
                    }

                    saveLikes.setLikes(saveLikes.getLikes() + 1);

                    Likesdislike savedLikes = saveLikesDislikeJPARepository.save(saveLikes);

                    return LikesDislikeResponse.of(savedLikes);
                } else {
                    System.out.println("좋아요나 싫어요를 눌렀던 게시글입니다");
                    return null;
                }

            case DISLIKE:

                Optional<Likesdislike> existingDislike = saveLikesDislikeJPARepository.findByArticleIdAndCreateMemberId(saveLikesDislikeRequest.articleId(),saveLikesDislikeRequest.createMemberId());

                if (existingDislike.isEmpty() || (existingDislike.isPresent() && existingDislike.get().getDislike() == 0 && existingDislike.get().getLikes() == 0)) {
                    Likesdislike saveDislike;

                    if (existingDislike.isPresent()) {
                        return null;
                    } else {
                        saveDislike = Likesdislike.from(saveLikesDislikeRequest);
                    }

                    saveDislike.setLikes(saveDislike.getLikes() + 1);

                    Likesdislike savedDIslike = saveLikesDislikeJPARepository.save(saveDislike);

                    return LikesDislikeResponse.of(savedDIslike);
                } else {
                    System.out.println("좋아요나 싫어요를 눌렀던 게시글입니다");
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
