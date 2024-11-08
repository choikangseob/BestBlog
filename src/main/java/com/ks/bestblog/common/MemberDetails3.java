package com.ks.bestblog.common;

import com.ks.bestblog.entity.Member3;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemberDetails3 implements UserDetails {

    private final Member3 member3;

    public MemberDetails3(Member3 member3) {

        this.member3 = member3;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member3.getEmail();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return member3.getPassword();
    }

    @Override
    public String getUsername() {
        return member3.getEmail();
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
