package com.qubitfaruk.bookstore.entities.concrete;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "title",nullable = false,length = 100)
    private String title;

    @Column(name = "author",nullable = false,length = 100)
    private String author;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "create_time")
    private LocalDateTime createTime;
}
