package com.cheesecrave.cheesecravedatabase.Model;

import com.cheesecrave.cheesecravedatabase.DTO.PurchaseProductDTO;
import com.cheesecrave.cheesecravedatabase.Service.PurchaseProductId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseProduct {
    @EmbeddedId
    private PurchaseProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchaseId")
    private Purchase purchase;

    @Column(name = "quantity") // number of product sold
    private int quantity;

    public static PurchaseProduct fromDTO(PurchaseProductDTO purchaseProductDTO, Purchase purchase, Product product) {

        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setProduct(product); // set the product entity on the PurchaseProduct
        purchaseProduct.setQuantity(purchaseProductDTO.getQuantity());
        purchaseProduct.setPurchase(purchase); // set the Purchase entity on the PurchaseProduct
        return purchaseProduct;
    }

}
