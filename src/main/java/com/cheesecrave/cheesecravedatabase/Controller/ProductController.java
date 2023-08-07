package com.cheesecrave.cheesecravedatabase.Controller;

import com.cheesecrave.cheesecravedatabase.DTO.ProductDTO;
import com.cheesecrave.cheesecravedatabase.Model.Product;
import com.cheesecrave.cheesecravedatabase.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/popular")
    public List<ProductDTO> getPopularCheeses() {
        System.out.println("Handling product inventory request...");
        return productService.findPopularCheeses();
    }


    @GetMapping("/inventory")
    public List<ProductDTO> get() {
        return productService.findAll();
    }

    @GetMapping("/inventory/{productId}")
    public Optional<ProductDTO> getById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @GetMapping("/price/range")
    public List<ProductDTO> getByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return productService.findByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/milktype/{milkType}")
    public List<ProductDTO> getByMilkType(@PathVariable String milkType) {
        return productService.findByMilkType(milkType);
    }

    @GetMapping("/texture/{texture}")
    public List<ProductDTO> getByTexture(@PathVariable String texture) {
        return productService.findByTexture(texture);
    }

    @GetMapping("/flavor/{flavor}")
    public List<ProductDTO> getByFlavor(@PathVariable String flavor) {
        return productService.findByFlavor(flavor);
    }

    @GetMapping("/vegetarian/{vegetarian}")
    public List<ProductDTO> getByVegetarian(@PathVariable Boolean vegetarian) {
        return productService.findByVegetarian(vegetarian);
    }

    @GetMapping("/type/{type}")
    public List<ProductDTO> getByType(@PathVariable String type) {
        return productService.findByType(type);
    }

    @GetMapping("/aroma/{aroma}")
    public List<ProductDTO> getByAroma(@PathVariable String aroma) {
        return productService.findByAroma(aroma);
    }

    @GetMapping("/search")
    public List<ProductDTO> search(@RequestParam String query) {
        return productService.search(query);
    }

    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable Long productId) {
        productService.delete(productId);
    }

//    @PatchMapping("/update/{productId}")
//    public ResponseEntity<ProductDTO> update(@PathVariable Long productId, @RequestBody Map<String, Object> updates) {
//        Optional<Product> optionalProduct = productService.findById(productId);
//        if (optionalProduct.isPresent()) {
//            Product product = optionalProduct.get();
//            if (updates.containsKey("name")) product.setName((String) updates.get("name"));
//            if (updates.containsKey("price")) product.setPrice(Double.parseDouble(updates.get("price").toString()));
//            if (updates.containsKey("type")) product.setType((String) updates.get("type"));
//            if (updates.containsKey("quantity")) product.setQuantity(Integer.parseInt(updates.get("quantity").toString()));
//            if (updates.containsKey("description")) product.setDescription((String) updates.get("description"));
//            productService.save(product);
//            return ResponseEntity.noContent().build();
//        } else return ResponseEntity.notFound().build();
//    }

}
