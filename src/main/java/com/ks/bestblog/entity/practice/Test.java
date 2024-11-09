package com.ks.bestblog.entity.practice;

import com.ks.bestblog.dto.request.practice.TestRequest;
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
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String realname;
    private int number;

    public Test(String realname, int number) {
        this.realname = realname;
        this.number = number;
    }

    public static Test from(TestRequest testRequest) {
        return new Test(testRequest);
    }
    public Test(TestRequest testRequest){
        this.realname = testRequest.realname();
        this.number = testRequest.number();

    }
}
