package com.ks.bestblog.entity;


import com.ks.bestblog.dto.request.JoinMemberRequest1;
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
public class Member1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String email;

    private String password;

    public static Member1 from(JoinMemberRequest1 joinMemberRequest1) {


        return new Member1(joinMemberRequest1);
    }

    public Member1(JoinMemberRequest1 joinMemberRequest1) {
        this.username = joinMemberRequest1.username();
        this.email = joinMemberRequest1.email();
        this.password = joinMemberRequest1.password();
    }
}
