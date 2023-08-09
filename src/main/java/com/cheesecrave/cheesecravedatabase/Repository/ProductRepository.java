package com.cheesecrave.cheesecravedatabase.Repository;

import com.cheesecrave.cheesecravedatabase.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // return instances of Product where the field matches the provided value
    List<Product> findByName(String name);
    List<Product> findByNameIn(List<String> names);
    List<Product> findByDescription(String description);
    List<Product> findByPrice(Double price);
    List<Product> findByQuantity(int quantity);
    List<Product> findByNameContaining(String query);
    List<Product> findByMilkType(String milkType);
    List<Product> findByTexture(String texture);
    List<Product> findByFlavor(String flavor);
    List<Product> findByVegetarian(Boolean vegetarian);
    List<Product> findByType(String type);
    List<Product> findByAroma(String aroma);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
