package com.cheesecrave.cheesecravedatabase.Repository;

import com.cheesecrave.cheesecravedatabase.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // return instances of Product where the field matches the provided value
    List<Product> findByName(String name);
    List<Product> findByDescription(String description);
    List<Product> findByPrice(Double price);
    List<Product> findByQuantity(int quantity);
    List<Product> findByNameContaining(String query);
}
