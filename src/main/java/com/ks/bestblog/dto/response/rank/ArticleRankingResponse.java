package com.ks.bestblog.dto.response.rank;


import lombok.Builder;


@Builder
public record ArticleRankingResponse(

        long rank,

        long id,

        String title,

        long count

) {

}
