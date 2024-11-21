package com.ks.bestblog.service.comment;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.dto.response.comment.CommentResponse;
import com.ks.bestblog.repository.comment.GetCommentJPARepository;
import com.ks.bestblog.repository.comment.GetCommentMybatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GetCommentService {

    private final GetCommentMybatisRepository getCommentMybatisRepository;

    private final GetCommentJPARepository getCommentJPARepository;

    public List<CommentResponse> getCommentAllById(long id) {




        return  getCommentMybatisRepository.findAllByArticleId(id);
    }


    public List<CommentResponse> getCommentByCreateMemberId(MemberDetails member){


        return getCommentJPARepository.findByCreateMemberId(member.getId());


    }
}
