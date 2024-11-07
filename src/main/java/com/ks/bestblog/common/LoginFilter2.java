/*
package com.ks.bestblog.common;


import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class LoginFilter2 extends UsernamePasswordAuthenticationFilter {

     public final AuthenticationManager authenticationManager;

     public final JWTUtil jwtUtil;

    public LoginFilter2(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);


        //인증진행
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);

        //검증진행
        return authenticationManager.authenticate(authToken);

    }

        @Override
        public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult){
            System.out.println("로그인 성공");

            MemberDetails2 memberDetails = (MemberDetails2) authResult.getPrincipal();

            String username = memberDetails.getUsername();

            Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
            Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
            GrantedAuthority auth = iterator.next();

            String role = auth.getAuthority();

            String token = jwtUtil.createJwt(username,role,60*60*10L);
            response.addHeader("Authorization", "Bearer "+token);
    }

        @Override
        public void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed){

            System.out.println("로그인 실패");

            response.setStatus(401);
        }
}
*/
