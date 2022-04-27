package com.qubitfaruk.bookstore.business.abstracts;

import com.qubitfaruk.bookstore.entities.concrete.PurchaseHistory;
import com.qubitfaruk.bookstore.entities.dto.PurchaseDto;

import java.util.List;

public interface IPurchaseService {
    PurchaseHistory savePurchase(PurchaseHistory purchaseHistory);
    List<PurchaseDto> findPurchasedItemsOfUser(Long id);

}
