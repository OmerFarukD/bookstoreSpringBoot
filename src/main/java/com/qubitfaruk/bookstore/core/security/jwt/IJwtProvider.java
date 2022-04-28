package com.qubitfaruk.bookstore.core.security.jwt;

import com.qubitfaruk.bookstore.core.security.UserPrincipal;

public interface IJwtProvider {
    String generateToken(UserPrincipal auth);
}
