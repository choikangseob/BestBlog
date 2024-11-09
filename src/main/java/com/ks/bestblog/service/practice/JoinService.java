/*
package com.ks.bestblog.service;

import com.ks.bestblog.dto.request.JoinRequest;
import com.ks.bestblog.entity.Userentity;
import com.ks.bestblog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class JoinService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public JoinService(UserRepository userRepository ,BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinRequest joinRequest){

        String username = joinRequest.username();
        String password = joinRequest.password();

        Boolean isExist = userRepository.existsByUsername(username);

        if(isExist){

            return;
        }

        Userentity data = new Userentity();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }


}
*/
