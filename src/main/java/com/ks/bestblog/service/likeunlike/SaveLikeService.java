package com.ks.bestblog.service.likeunlike;


import com.ks.bestblog.dto.request.likeunlike.SaveLikeRequest;
import com.ks.bestblog.dto.response.likeunlike.LikeResponse;
import com.ks.bestblog.entity.Likeunlike;
import com.ks.bestblog.repository.likeunlike.SaveLikeUnlikeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveLikeService {

    private final SaveLikeUnlikeJPARepository saveLikeUnlikeJPARepository;

    public LikeResponse saveLike(SaveLikeRequest saveLikeRequest){

        Likeunlike outOfSavedLike = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            System.out.println("로그인 하지 않은 분은 좋아요를 누를 수 없습니다");
            return null;


        }else{
            Likeunlike saveLike= Likeunlike.from(saveLikeRequest);

            Likeunlike savedLike = saveLikeUnlikeJPARepository.save(saveLike);

            outOfSavedLike = savedLike;
        }

        return LikeResponse.of(outOfSavedLike);
    }
}
