package com.ks.bestblog.service.likeunlike;


import com.ks.bestblog.dto.request.likeunlike.SaveLikesDislikeRequest;
import com.ks.bestblog.dto.response.likeunlike.LikesDislikeResponse;
import com.ks.bestblog.entity.Likesdislike;
import com.ks.bestblog.repository.likeunlike.SaveLikesDislikeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlertLikeDislikeService {

    private final SaveLikesDislikeJPARepository saveLikesDislikeJPARepository;

    public LikesDislikeResponse saveLike(SaveLikesDislikeRequest saveLikesDislikeRequest, Authentication authentication){

        Likesdislike outOfSavedLikes = null;


        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            System.out.println("로그인 하지 않은 분은 좋아요,싫어요 를 누를 수 없습니다");
            return null;


        }else{
            Likesdislike saveLike= Likesdislike.from(saveLikesDislikeRequest);

            Likesdislike savedLike = saveLikesDislikeJPARepository.save(saveLike);

            outOfSavedLikes = savedLike;
        }

        return LikesDislikeResponse.of(outOfSavedLikes);
    }
}
