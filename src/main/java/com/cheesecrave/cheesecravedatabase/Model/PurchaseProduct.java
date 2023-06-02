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

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productId")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("purchaseId")
    private Purchase purchase;

    @Column(name = "quantity")
    private int quantity;

    public static PurchaseProduct fromDTO(PurchaseProductDTO purchaseProductDTO, Purchase purchase) {
        PurchaseProduct purchaseProduct = new PurchaseProduct();
        PurchaseProductId purchaseProductId = new PurchaseProductId();
        purchaseProductId.setProductId(purchaseProductDTO.getProductId());
        purchaseProduct.setId(purchaseProductId);
        purchaseProduct.setQuantity(purchaseProductDTO.getQuantity());
        purchaseProduct.setPurchase(purchase);
        return purchaseProduct;
    }

}
