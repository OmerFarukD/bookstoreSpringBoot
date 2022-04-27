package com.qubitfaruk.bookstore.core.dataAccess;

import com.qubitfaruk.bookstore.core.entity.Role;
import com.qubitfaruk.bookstore.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);

    @Modifying
    @Query("update User set role =:role where userName=:username ")
    void updateRole(@Param("username") String username, @Param("role")Role role);
}
