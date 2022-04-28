package com.qubitfaruk.bookstore.core.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {
    public static final String ROLE_PREFİX="ROLE_";
    public static final String AUTH_HEADER="authorization";
    public static final String AUTH_TOKEN_TYPE="Bearer";
    public static final String AUTH_TOKEN_PREFIX=AUTH_TOKEN_TYPE+" ";

    public static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole=role.startsWith(ROLE_PREFİX) ? role:ROLE_PREFİX+role;
        return  new SimpleGrantedAuthority(formattedRole);
    }
    public static String extracthAuthTokenFromRequest(HttpServletRequest request){
        String bearerToken=request.getHeader(AUTH_HEADER);
        if(!StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX)){
            return bearerToken.substring(7);
        }
        return null;
    }
}
