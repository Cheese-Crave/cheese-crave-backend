package com.cheesecrave.cheesecravedatabase.Service;
import com.cheesecrave.cheesecravedatabase.DTO.ProductDTO;
import com.cheesecrave.cheesecravedatabase.Model.Product;
import com.cheesecrave.cheesecravedatabase.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> findById(Long productId) throws RuntimeException {
        Optional<Product> product = productRepository.findById(productId);
        return product.map(this::convertToDTO);
    }

    @Override
    public List<ProductDTO> search(String query) {
        List<Product> products = productRepository.findByNameContaining(query);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDTO> findByMilkType(String milkType) {
        List<Product> products = productRepository.findByMilkType(milkType);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByTexture(String texture) {
        List<Product> products = productRepository.findByTexture(texture);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByFlavor(String flavor) {
        List<Product> products = productRepository.findByFlavor(flavor);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByVegetarian(Boolean vegetarian) {
        List<Product> products = productRepository.findByVegetarian(vegetarian);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByType(String type) {
        List<Product> products = productRepository.findByType(type);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByAroma(String aroma) {
        List<Product> products = productRepository.findByAroma(aroma);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByPriceBetween(Double minPrice, Double maxPrice) {
        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(
            product.getProductId(),
            product.getName(),
            product.getImage(),
            product.getDescription(),
            product.getPrice(),
            product.getMilkType(),
            product.getType(),
            product.getQuantity(),
            product.getAroma(),
            product.getTexture(),
            product.getVegetarian(),
            product.getFlavor()
        );
    }
}

