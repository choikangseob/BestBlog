package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.InsertReplyRequest;
import com.ks.bestblog.dto.response.InsertReplyResponse;
import com.ks.bestblog.entity.Reply;
import com.ks.bestblog.repository.InsertReplyRepository;
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
