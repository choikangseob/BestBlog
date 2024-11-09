package com.ks.bestblog.entity.practice;


import com.ks.bestblog.dto.request.practice.InsertMenuRequest;
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
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String menuname;

    private int price;

    public Menu(String menuname, int price) {
        this.menuname = menuname;
        this.price = price;
    }
    public static Menu from(InsertMenuRequest insertMenuRequest){
        return new Menu(insertMenuRequest);
    }
    public Menu(InsertMenuRequest insertMenuRequest){
        this.menuname = insertMenuRequest.menuname();
        this.price = insertMenuRequest.price();
    }
}
