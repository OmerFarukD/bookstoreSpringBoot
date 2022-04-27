package com.qubitfaruk.bookstore.entities.dto;

import java.time.LocalDateTime;

public interface PurchaseDto {
    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
