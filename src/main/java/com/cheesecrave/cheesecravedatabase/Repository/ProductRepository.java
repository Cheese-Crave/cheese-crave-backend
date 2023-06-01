package com.cheesecrave.cheesecravedatabase.Repository;

import com.cheesecrave.cheesecravedatabase.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // get product information
    Product getByName(String name);
    Product getByDescription(String description);
    Product getByPrice(Double price);
    Product getByQuantity(int quantity);
}
