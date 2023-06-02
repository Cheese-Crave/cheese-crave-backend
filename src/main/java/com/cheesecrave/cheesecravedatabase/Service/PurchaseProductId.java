package com.cheesecrave.cheesecravedatabase.Service;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseProductId implements Serializable {
    private Long productId;
    private Long purchaseId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseProductId that = (PurchaseProductId) o;
        return Objects.equals(purchaseId, that.purchaseId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, productId);
    }

    public void setPurchaseId(Long purchaseId) {
    }

    public void setProductId(Long productId) {
    }
}