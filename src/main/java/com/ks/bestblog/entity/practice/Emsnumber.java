package com.ks.bestblog.entity.practice;


import com.ks.bestblog.dto.request.practice.JoinEmsnumberRequest;
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
public class Emsnumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String department;
    private int number;

    public Emsnumber(String department, int number) {
        this.department = department;
        this.number = number;
    }
    public static Emsnumber from(JoinEmsnumberRequest joinEmsnumberRequest){
        return new Emsnumber(joinEmsnumberRequest);
    }

    public Emsnumber(JoinEmsnumberRequest joinEmsnumberRequest) {
        this.department = joinEmsnumberRequest.department();
        this.number = joinEmsnumberRequest.number();
    }
}
