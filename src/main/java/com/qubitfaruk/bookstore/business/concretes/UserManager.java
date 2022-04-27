package com.qubitfaruk.bookstore.business.concretes;

import com.qubitfaruk.bookstore.business.abstracts.IUserService;
import com.qubitfaruk.bookstore.core.dataAccess.IUserRepository;
import com.qubitfaruk.bookstore.core.entity.Role;
import com.qubitfaruk.bookstore.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserManager implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setCreateTime(LocalDateTime.now());
      user.setRole(Role.USER);
      return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public void makeAdmin(String userName) {
        this.userRepository.updateRole(userName, Role.ADMIN);
    }

}
