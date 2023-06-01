package com.cheesecrave.cheesecravedatabase.Repository;


import com.cheesecrave.cheesecravedatabase.Model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    Sales getByQuantity(String quantity);
    Sales getByTotalPrice(double totalPrice);

}
