package com.qubitfaruk.bookstore.business.concretes;

import com.qubitfaruk.bookstore.business.abstracts.IPurchaseService;
import com.qubitfaruk.bookstore.dataAccess.IPurchaseHistoryRepository;
import com.qubitfaruk.bookstore.entities.concrete.PurchaseHistory;
import com.qubitfaruk.bookstore.entities.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PurchaseManager implements IPurchaseService {
    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;
    @Override
    public PurchaseHistory savePurchase(PurchaseHistory purchaseHistory) {
        return this.purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<PurchaseDto> findPurchasedItemsOfUser(Long id) {
        return this.purchaseHistoryRepository.getAllPurchasesOfUser(id);
    }
}
