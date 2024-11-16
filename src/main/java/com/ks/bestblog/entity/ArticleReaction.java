package com.ks.bestblog.entity;

import com.ks.bestblog.common.MemberDetails;
import com.ks.bestblog.common.entity.EssentialColumns;
import com.ks.bestblog.enums.ArticleReactionType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleReaction extends EssentialColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long articleId;

    private long createMemberId;

    @Enumerated(EnumType.STRING)
    private ArticleReactionType type;



    public static ArticleReaction from(long articleId, ArticleReactionType type, MemberDetails member) {

        return new ArticleReaction(articleId,type,member);

    }

    public ArticleReaction(long articleId, ArticleReactionType type, MemberDetails member) {
        this.articleId = articleId;
        this.type = type;
        this.createMemberId = member.getId();
    }
}
