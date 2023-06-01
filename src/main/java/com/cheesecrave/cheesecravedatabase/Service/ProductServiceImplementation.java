package com.cheesecrave.cheesecravedatabase.Service;
import com.cheesecrave.cheesecravedatabase.Model.Product;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImplementation implements ProductService {

    @Override
    public void add(Product product) {

    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void delete(Long Id) {

    }

    @Override
    public Product findById(Long Id) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public Product findByPrice(double price) {
        return null;
    }

    @Override
    public Product findByType(String type) {
        return null;
    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }
}
