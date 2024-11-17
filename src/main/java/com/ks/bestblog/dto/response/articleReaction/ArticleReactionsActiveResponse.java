package com.ks.bestblog.dto.response.articleReaction;


import com.ks.bestblog.enums.ArticleReactionType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ArticleReactionsActiveResponse {
    private Boolean like;

    private Boolean dislike;

    private Boolean sad;

    private Boolean angry;


    public void from(ArticleReactionType articleReactionType, boolean active) {

        switch (articleReactionType) {
            case LIKE:

                this.like = active;

            case DISLIKE:

                this.dislike = active;

            case SAD:

                this.sad = active;

            case ANGRY:

                this.angry = active;

        }

    }
}
