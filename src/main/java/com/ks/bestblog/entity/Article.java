package com.ks.bestblog.entity;


import com.ks.bestblog.common.entity.EssentialColumns;
import com.ks.bestblog.dto.request.article.SaveArticleRequest;
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
public class Article extends EssentialColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;

    private long categoryId;

    public static Article from(SaveArticleRequest saveArticleRequest){
        return new Article(saveArticleRequest);
    }

    public Article(SaveArticleRequest saveArticleRequest) {

        this.id = saveArticleRequest.id();
        this.title = saveArticleRequest.title();
        this.content = saveArticleRequest.content();
        this.categoryId = saveArticleRequest.categoryId();
    }
}
