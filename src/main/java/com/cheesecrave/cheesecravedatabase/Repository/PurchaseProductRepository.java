package com.cheesecrave.cheesecravedatabase.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cheesecrave.cheesecravedatabase.Model.PurchaseProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long> {

}

