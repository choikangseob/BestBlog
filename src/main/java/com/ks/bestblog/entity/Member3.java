package com.ks.bestblog.entity;


import com.ks.bestblog.dto.request.JoinMemberRequest3;
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
public class Member3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String email;

    private String password;


    public static Member3 from(JoinMemberRequest3 joinMemberRequest3) {

        return new Member3(joinMemberRequest3);
    }

    public Member3(JoinMemberRequest3 joinMemberRequest3) {
        this.username = joinMemberRequest3.username();
        this.email = joinMemberRequest3.email();
        this.password = joinMemberRequest3.password();
    }
}
