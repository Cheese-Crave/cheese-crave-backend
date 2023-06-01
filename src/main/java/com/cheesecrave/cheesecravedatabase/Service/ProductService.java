package com.cheesecrave.cheesecravedatabase.Service;

import com.cheesecrave.cheesecravedatabase.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void save(Product product);
    void delete(Long productId);
    Product findById(Long productId);
    Iterable<Product> findAll();
    List<Product> search(String query);
}
