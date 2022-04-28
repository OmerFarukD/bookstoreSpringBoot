package com.qubitfaruk.bookstore.core.business.abstracts;

import com.qubitfaruk.bookstore.core.entity.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);
    Optional<User> findByUserName(String userName);
    void makeAdmin(String userName);
}
