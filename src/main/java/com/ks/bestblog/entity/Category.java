package com.ks.bestblog.entity;


import com.ks.bestblog.common.entity.EssentialColumns;
import com.ks.bestblog.dto.request.SaveCategoryRequest;
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
public class Category extends EssentialColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long parentId;

    private long depth;

    private String title;

    public static Category from (SaveCategoryRequest saveCategoryRequest){

        return new Category(saveCategoryRequest);

    }

    public Category(SaveCategoryRequest saveCategoryRequest) {

        this.depth = saveCategoryRequest.depth();

        this.title = saveCategoryRequest.title();

        this.parentId = saveCategoryRequest.parentId();
    }

}
