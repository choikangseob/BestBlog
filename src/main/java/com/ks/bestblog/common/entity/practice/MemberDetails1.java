/*
package com.ks.bestblog.common;

import com.ks.bestblog.entity.Member1;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MemberDetails1 implements UserDetails {

    private final Member1 member1;

    public MemberDetails1(Member1 member1) {
        this.member1 = member1;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

      Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member1.getEmail();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return member1.getPassword();
    }

    @Override
    public String getUsername() {
        return member1.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
*/
