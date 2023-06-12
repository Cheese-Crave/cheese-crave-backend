package com.cheesecrave.cheesecravedatabase.Controller;

import com.cheesecrave.cheesecravedatabase.DTO.PurchaseDTO;
import com.cheesecrave.cheesecravedatabase.DTO.PurchaseProductDTO;
import com.cheesecrave.cheesecravedatabase.Model.Customer;
import com.cheesecrave.cheesecravedatabase.Model.Product;
import com.cheesecrave.cheesecravedatabase.Model.Purchase;
import com.cheesecrave.cheesecravedatabase.Model.PurchaseProduct;
import com.cheesecrave.cheesecravedatabase.Repository.CustomerRepository;
import com.cheesecrave.cheesecravedatabase.Repository.ProductRepository;
import com.cheesecrave.cheesecravedatabase.Repository.PurchaseProductRepository;
import com.cheesecrave.cheesecravedatabase.Repository.PurchaseRepository;
import com.cheesecrave.cheesecravedatabase.Service.PurchaseService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    public PurchaseController(PurchaseService purchaseService, CustomerRepository customerRepository, PurchaseRepository purchaseRepository, ProductRepository productRepository, PurchaseProductRepository purchaseProductRepository) {
        this.purchaseService = purchaseService;
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
        this.purchaseProductRepository = purchaseProductRepository;
    }

    @GetMapping("/{purchaseId}")
    public Purchase findById(@PathVariable Long purchaseId) {
        return purchaseService.findById(purchaseId);
    }

    @PostMapping("/new")
    public void add(@RequestBody Purchase purchase) {
        purchaseService.save(purchase);
    }

    @PostMapping("/api/purchase/new")
    public ResponseEntity<Purchase> createPurchase(@RequestBody PurchaseDTO purchaseDTO) {

        // check that a customer exists with the accountNumber provided
        Optional<Customer> verifyCustomer = customerRepository.findById(purchaseDTO.getAccountNumber());
        if (!verifyCustomer.isPresent()) { // if the customer exists, create the purchase
            System.out.println("No customer with accountNumber: " + purchaseDTO.getAccountNumber());
            return ResponseEntity.badRequest().body(null);
        }

        Customer customer = verifyCustomer.get(); // Getting the Customer object from the Optional<Customer> object
        Purchase purchase = new Purchase(); // Creating the Purchase object

        purchase.setTotalPrice(purchaseDTO.getTotalPrice()); // Setting the Purchase TotalPrice field
        purchase.setOrderQuantity(purchaseDTO.getOrderQuantity()); // Setting the Purchase OrderQuantity field
        purchase.setCustomer(customer);  // Setting the Purchase Customer field

        // Creating the PurchaseProduct objects
        for (PurchaseProductDTO purchaseProductDTO : purchaseDTO.getPurchaseProducts()) {
            Optional<Product> productOpt = productRepository.findById(purchaseProductDTO.getProductId());
            if (!productOpt.isPresent()) {
                System.out.println("No product with id: " + purchaseProductDTO.getProductId());
            }
            PurchaseProduct purchaseProduct = PurchaseProduct.fromDTO(purchaseProductDTO, purchase, productOpt.get());
            purchase.getPurchaseProducts().add(purchaseProduct);
        }

        try {
            purchase = purchaseRepository.save(purchase); // Saving the Purchase first
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body(null);

        }
        purchase = purchaseRepository.save(purchase); // Saving the Purchase again to update the PurchaseProducts

        return ResponseEntity.ok(purchase);
    }


    @DeleteMapping("/delete/{purchaseId}")
    public void delete(@PathVariable Long purchaseId) {
        purchaseService.delete(purchaseId);
    }
}
