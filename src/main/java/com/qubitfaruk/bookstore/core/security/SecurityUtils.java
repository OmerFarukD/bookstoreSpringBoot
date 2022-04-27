package com.qubitfaruk.bookstore.core.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SecurityUtils {
    public static final String ROLE_PREFİX="ROLE_";
    public static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole=role.startsWith(ROLE_PREFİX) ? role:ROLE_PREFİX+role;
        return  new SimpleGrantedAuthority(formattedRole);
    }
}
