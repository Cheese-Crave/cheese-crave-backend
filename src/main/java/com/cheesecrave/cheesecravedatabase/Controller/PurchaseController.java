package com.cheesecrave.cheesecravedatabase.Controller;

import com.cheesecrave.cheesecravedatabase.DTO.PurchaseDTO;
import com.cheesecrave.cheesecravedatabase.DTO.PurchaseProductDTO;
import com.cheesecrave.cheesecravedatabase.Model.Customer;
import com.cheesecrave.cheesecravedatabase.Model.Purchase;
import com.cheesecrave.cheesecravedatabase.Model.PurchaseProduct;
import com.cheesecrave.cheesecravedatabase.Repository.CustomerRepository;
import com.cheesecrave.cheesecravedatabase.Repository.PurchaseRepository;
import com.cheesecrave.cheesecravedatabase.Service.PurchaseProductId;
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
    public PurchaseController(PurchaseService purchaseService, CustomerRepository customerRepository, PurchaseRepository purchaseRepository) {
        this.purchaseService = purchaseService;
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
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
        Optional<Customer> verifyCustomer = customerRepository.findById(purchaseDTO.getAccountNumber());
        if (verifyCustomer.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Customer customer = verifyCustomer.get();
        Purchase purchase = new Purchase();
        purchase.setTotalPrice(purchaseDTO.getTotalPrice());
        purchase.setOrderQuantity(purchaseDTO.getOrderQuantity());
        purchase.setCustomer(customer);

        // Saving the Purchase first
        try {
            purchase = purchaseRepository.save(purchase);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body(null);
        }

        for (PurchaseProductDTO purchaseProductDTO : purchaseDTO.getPurchaseProducts()) {
            PurchaseProduct purchaseProduct = PurchaseProduct.fromDTO(purchaseProductDTO, purchase);
            purchase.getPurchaseProducts().add(purchaseProduct);
        }

        // Updating the Purchase with the PurchaseProducts
        try {
            purchase = purchaseRepository.save(purchase);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(purchase);
    }


    @DeleteMapping("/delete/{purchaseId}")
    public void delete(@PathVariable Long purchaseId) {
        purchaseService.delete(purchaseId);
    }
}
