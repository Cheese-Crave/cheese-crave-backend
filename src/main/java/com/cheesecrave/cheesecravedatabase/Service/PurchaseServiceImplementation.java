package com.cheesecrave.cheesecravedatabase.Service;

import com.cheesecrave.cheesecravedatabase.Model.Customer;
import com.cheesecrave.cheesecravedatabase.Model.Product;
import com.cheesecrave.cheesecravedatabase.Model.Purchase;
import com.cheesecrave.cheesecravedatabase.Model.PurchaseProduct;
import com.cheesecrave.cheesecravedatabase.Repository.PurchaseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PurchaseServiceImplementation implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    public PurchaseServiceImplementation(PurchaseRepository purchaseRepository, CustomerService customerService, ProductService productService) {
        this.purchaseRepository = purchaseRepository;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Override
    public Purchase findById(Long purchaseId) {
        return purchaseRepository.findById(purchaseId).orElseThrow(() -> new EntityNotFoundException("No Purchase found with id: " + purchaseId));
    }

    @Override
    public List<Purchase> searchByQuantity(String orderQuantity) {
        return (List<Purchase>) purchaseRepository.getByOrderQuantity(orderQuantity);
    }

    @Override
    public List<Purchase> searchByPrice(double totalPrice) {
        return (List<Purchase>) purchaseRepository.getByTotalPrice(totalPrice);
    }

    @Override
    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public void delete(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }

    @Transactional
    public Purchase createPurchase(Purchase purchase, Set<Product> products, Customer customer) {
        purchase.setCustomer(customer);
        customer.getPurchase().add(purchase);
        customerService.save(customer);

        for (Product product : products) {
            PurchaseProduct purchaseProduct = new PurchaseProduct();
            purchaseProduct.setPurchase(purchase);
            purchaseProduct.setProduct(product);
            purchase.getPurchaseProducts().add(purchaseProduct);
            product.getPurchaseProducts().add(purchaseProduct);
            productService.save(product);


        }
        return purchaseRepository.save(purchase);
    }
}
