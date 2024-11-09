package com.ks.bestblog.entity.practice;

import com.ks.bestblog.dto.request.practice.InsertReplyRequest;
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
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    private String uid;

    public Reply(String comment, String uid) {
        this.comment = comment;
        this.uid = uid;
    }

    public static Reply from(InsertReplyRequest insertReplyRequest){
     return new Reply(insertReplyRequest);
    }

    public Reply (InsertReplyRequest insertReplyRequest){
        this.comment =insertReplyRequest.comment();
        this.uid = insertReplyRequest.uid();
    }
}
