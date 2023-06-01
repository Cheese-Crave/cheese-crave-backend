package com.cheesecrave.cheesecravedatabase.Service;

import com.cheesecrave.cheesecravedatabase.Model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    // add products
    void add(Product product);

    //update products
    void save(Product product);

    // delete products
    void delete(Product product);
    void delete(Long Id);

    // find by id, email, phone, first name, last name
    Product findById( Long Id );
    Product findByName( String name );
    Product findByPrice( double price );
    Product findByType( String type );

    // find all products
    Iterable<Product> findAll();
}
