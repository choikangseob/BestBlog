package com.ks.bestblog.entity;


import com.ks.bestblog.dto.request.member.JoinMemberRequest;
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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String email;

    private String password;

    private String introduction;

    private String profileImageUrl;

    public Member(String username, String email){

        this.username = username;
        this.email = email;

    }

    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static Member from(JoinMemberRequest joinMemberRequest) {

        return new Member(joinMemberRequest);
    }

    public Member(JoinMemberRequest joinMemberRequest) {
        this.username = joinMemberRequest.username();
        this.email = joinMemberRequest.email();
        this.password = joinMemberRequest.password();
        this.introduction = joinMemberRequest.introduction();
        this.profileImageUrl = joinMemberRequest.profileImageUrl();

    }
}
