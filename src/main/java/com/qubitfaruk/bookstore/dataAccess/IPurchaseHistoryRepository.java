package com.qubitfaruk.bookstore.dataAccess;

import com.qubitfaruk.bookstore.entities.concrete.PurchaseHistory;
import com.qubitfaruk.bookstore.entities.dto.PurchaseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory,Long> {
    @Query("select " +
            "b.title as title, ph.price as price, ph.createTime as purchaseTime  " +
            "from PurchaseHistory ph left join Book b on b.Id = ph.bookId " +
            "where ph.userId = :userId")
    List<PurchaseDto> findAllPurchasesOfUser(@Param("userId") Long userId);
}
