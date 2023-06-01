package com.cheesecrave.cheesecravedatabase.Controller;

import com.cheesecrave.cheesecravedatabase.Model.Product;
import com.cheesecrave.cheesecravedatabase.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/inventory")
    public Iterable<Product> get(){
        return productService.findAll();
    }

    @GetMapping("/inventory/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @PostMapping("/new")
    public void add(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable Long productId) {
        productService.delete(productId);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String query) {
        return productService.search(query);
    }

    @PatchMapping("/update/{productId}")
    public ResponseEntity<Void> update(@PathVariable Long productId, @RequestBody Map<String, Object> updates) {
        Product product = productService.findById(productId);
        if (product != null) {
            if (updates.containsKey("name")) {
                product.setName((String) updates.get("name"));
            }
            if (updates.containsKey("price")) {
                product.setPrice(Double.parseDouble(updates.get("price").toString()));
            }
            if (updates.containsKey("type")) {
                product.setType((String) updates.get("type"));
            }
            if (updates.containsKey("quantity")) {
                product.setQuantity(Integer.parseInt(updates.get("quantity").toString()));
            }
            if (updates.containsKey("description")) {
                product.setDescription((String) updates.get("description"));
            }
            productService.save(product);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
