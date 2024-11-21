package com.ks.bestblog.entity;

import com.ks.bestblog.common.entity.EssentialColumns;
import com.ks.bestblog.dto.request.comment.SaveCommentRequest;
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
public class Comment extends EssentialColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long articleId;

    private Long depth;

    private Long parentId;

    private String comment;

    public static Comment from(SaveCommentRequest saveCommentRequest){

        return new Comment(saveCommentRequest);
    }

    public Comment(SaveCommentRequest saveCommentRequest) {

        this.articleId = saveCommentRequest.articleId();

        this.depth = saveCommentRequest.depth();

        this.parentId = saveCommentRequest.parentId();

        this.comment = saveCommentRequest.comment();
    }
}
