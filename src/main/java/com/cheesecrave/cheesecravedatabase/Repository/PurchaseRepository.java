package com.cheesecrave.cheesecravedatabase.Repository;


import com.cheesecrave.cheesecravedatabase.Model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    Purchase getByOrderQuantity(String orderQuantity);
    Purchase getByTotalPrice(double totalPrice);

}