package com.cheesecrave.cheesecravedatabase.Service;

import com.cheesecrave.cheesecravedatabase.DTO.ProductDTO;
import com.cheesecrave.cheesecravedatabase.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Optional<ProductDTO> findById(Long productId) throws RuntimeException;
    List<ProductDTO> findAll();
    List<ProductDTO> search(String query);
    List<ProductDTO> findByMilkType(String milkType);
    List<ProductDTO> findByTexture(String texture);
    List<ProductDTO> findByFlavor(String flavor);
    List<ProductDTO> findByVegetarian(Boolean vegetarian);
    List<ProductDTO> findByType(String type);
    List<ProductDTO> findByAroma(String aroma);
    List<ProductDTO> findByPriceBetween(Double minPrice, Double maxPrice);
    void save(Product product);
    void delete(Long productId);


}
