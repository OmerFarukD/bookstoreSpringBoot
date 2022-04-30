package com.qubitfaruk.bookstore.business.abstracts;

import com.qubitfaruk.bookstore.core.entity.User;

public interface IAuthenticationService {
    User sıgnInAndReturnJwt(User signingRequest);
}
