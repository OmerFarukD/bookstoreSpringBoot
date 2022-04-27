package com.qubitfaruk.bookstore.dataAccess;

import com.qubitfaruk.bookstore.entities.concrete.PurchaseHistory;
import com.qubitfaruk.bookstore.entities.dto.PurchaseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory,Long> {
    @Query("b.title as title ,ph.purchaseTime as purchaseTime " +
            "select * from  PurchaseHistory ph left join Book b on b.id=ph.bookId" +
            "where ph.userId=:userId")
    List<PurchaseDto> getAllPurchasesOfUser(@Param("userId") Long userId);
}
