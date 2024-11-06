package com.ks.bestblog.common;

import com.ks.bestblog.entity.Member2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemberDetails2 implements UserDetails {

    private Member2 member2;


    public MemberDetails2(Member2 member2) {
        this.member2 = member2;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();

       collection.add(new GrantedAuthority() {
           @Override
           public String getAuthority() {
               return member2.getEmail();
           }
       });
        return collection;
    }

    @Override
    public String getPassword() {
        return member2.getPassword();
    }

    @Override
    public String getUsername() {
        return member2.getEmail();
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
