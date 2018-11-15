package com.seb.weekninechallenge.Service;


import com.seb.weekninechallenge.Model.AppUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {
    private AppUser appUser;

    public CustomUserDetails(AppUser appUser, String password, Collection<? extends GrantedAuthority> authories){
        super(appUser.getUserName(),password,authories);
        this.appUser=appUser;
    }
    public CustomUserDetails(AppUser appUser, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities){
        super(appUser.getUserName(), appUser.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
        this.appUser = appUser;
    }
    public AppUser getUser(){
        return appUser;
    }
}