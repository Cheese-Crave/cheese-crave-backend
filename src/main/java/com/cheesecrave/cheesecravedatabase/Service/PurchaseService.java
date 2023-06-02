package com.cheesecrave.cheesecravedatabase.Service;

import com.cheesecrave.cheesecravedatabase.Model.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {
    Purchase findById(Long purchaseId);

    List<Purchase> searchByQuantity(String quantity);

    List<Purchase> searchByPrice(double totalPrice);

    void save(Purchase purchase);
    void delete(Long purchaseId);
}
