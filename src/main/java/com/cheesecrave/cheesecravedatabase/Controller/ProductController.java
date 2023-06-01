package com.cheesecrave.cheesecravedatabase.Controller;

import com.cheesecrave.cheesecravedatabase.Model.Product;
import com.cheesecrave.cheesecravedatabase.Service.ProductService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public void add(@RequestBody Product product) {
        productService.add(product);
        productService.save(product);
    }

    @PutMapping("/update")
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/delete")
     public void delete(@RequestBody Product product ) {

    }

}
