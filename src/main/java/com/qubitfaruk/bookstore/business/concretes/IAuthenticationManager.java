package com.qubitfaruk.bookstore.business.concretes;

import com.qubitfaruk.bookstore.business.abstracts.IAuthenticationService;
import com.qubitfaruk.bookstore.core.entity.User;
import com.qubitfaruk.bookstore.core.security.UserPrincipal;
import com.qubitfaruk.bookstore.core.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class IAuthenticationManager implements IAuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IJwtProvider jwtProvider;
    @Override
    public User sıgnInAndReturnJwt(User signingRequest){
        Authentication authentication=this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signingRequest.getUserName(),signingRequest.getPassword())
        );
        UserPrincipal userPrincipal= (UserPrincipal) authentication.getPrincipal();
        String jwt=jwtProvider.generateToken(userPrincipal);
        User signUser=userPrincipal.getUser();
        signUser.setToken(jwt);
        return signUser;
    }
}
