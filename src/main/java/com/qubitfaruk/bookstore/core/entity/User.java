package com.qubitfaruk.bookstore.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "user_name",unique = true,length = 100,nullable = false)
    private String userName;

    @Column(name = "name",unique = true,length = 100,nullable = false)
    private String name;
    @Column(name = "password",nullable = false,length = 100)
    private String password;

    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;


    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;

    @Transient
    private String Token;
}
