package com.qubitfaruk.bookstore.api.controller;


import com.qubitfaruk.bookstore.business.abstracts.IPurchaseService;
import com.qubitfaruk.bookstore.core.security.UserPrincipal;
import com.qubitfaruk.bookstore.entities.concrete.PurchaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase-history")
public class PurchaseHistoriesController {
    @Autowired
   private IPurchaseService purchaseService;
    @PostMapping("/add-purchase")
    public ResponseEntity<?> savePurchase(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(this.purchaseService.savePurchase(purchaseHistory), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return new ResponseEntity<>(this.purchaseService.findPurchasedItemsOfUser(userPrincipal.getId()),HttpStatus.OK);

    }
}
