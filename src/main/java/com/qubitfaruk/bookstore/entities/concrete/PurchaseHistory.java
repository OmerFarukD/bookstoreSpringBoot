package com.qubitfaruk.bookstore.entities.concrete;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_history")
@Data
public class PurchaseHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "book_id",nullable = false)
    private Long bookId;

    @Column(name = "price",nullable = false)
    private Double price;


    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

}
