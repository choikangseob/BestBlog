/*
package com.ks.bestblog.entity;


import com.ks.bestblog.dto.request.JoinMemberRequest2;
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
public class Member2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String email;

    private String password;

    public static Member2 from(JoinMemberRequest2  joinMemberRequest2) {

        return new Member2(joinMemberRequest2);

    }

    public Member2(JoinMemberRequest2  joinMemberRequest2) {
        this.username = joinMemberRequest2.username();
        this.email = joinMemberRequest2.email();
        this.password = joinMemberRequest2.password();
    }
}
*/
