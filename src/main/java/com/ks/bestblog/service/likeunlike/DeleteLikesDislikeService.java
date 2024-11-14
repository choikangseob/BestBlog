package com.ks.bestblog.service.likeunlike;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.request.likeunlike.DeleteLikesDislikeRequest;
import com.ks.bestblog.dto.response.likeunlike.DeleteLikesDislikeResponse;
import com.ks.bestblog.entity.Likesdislike;
import com.ks.bestblog.repository.likeunlike.DeleteLikesDislikeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteLikesDislikeService {

    private final DeleteLikesDislikeJPARepository deleteLikesDislikeJPARepository;

    public DeleteLikesDislikeResponse deleteLikesDislike(DeleteLikesDislikeRequest deleteLikesDislikeRequest, MemberDetails member,SelectType selectType) {

        switch (selectType){
            case LIKE:
                Optional<Likesdislike> deleteLikesById = deleteLikesDislikeJPARepository.findLikesdislikeById(deleteLikesDislikeRequest.id());
                Likesdislike likesTobedelete = deleteLikesById.orElseThrow(() -> new RuntimeException("취소할 좋아요가 없습니다"));
                deleteLikesDislikeJPARepository.delete(likesTobedelete);

                return DeleteLikesDislikeResponse.of(likesTobedelete);

            case DISLIKE:
                Optional<Likesdislike> deleteDislikesById = deleteLikesDislikeJPARepository.findLikesdislikeById(deleteLikesDislikeRequest.id());
                Likesdislike disLikeTobeDelete = deleteDislikesById.orElseThrow(()->new RuntimeException("취소할 싫어요가 없습니다"));
                deleteLikesDislikeJPARepository.delete(disLikeTobeDelete);

                return DeleteLikesDislikeResponse.of(disLikeTobeDelete);

            default:
                return null;
        }


    }

    public enum SelectType {
        LIKE , DISLIKE
    }
}
