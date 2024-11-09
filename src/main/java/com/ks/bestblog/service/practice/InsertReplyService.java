package com.ks.bestblog.service.practice;

import com.ks.bestblog.dto.request.practice.InsertReplyRequest;
import com.ks.bestblog.dto.response.practice.InsertReplyResponse;
import com.ks.bestblog.entity.practice.Reply;
import com.ks.bestblog.repository.pratice.InsertReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsertReplyService {

    public final InsertReplyRepository insertReplyRepository;

    public InsertReplyResponse insertReply(InsertReplyRequest insertReplyRequest) {

        Reply insertReply = Reply.from(insertReplyRequest);
        Reply savedReply = insertReplyRepository.save(insertReply);
        return InsertReplyResponse.of(savedReply);
    }
}
