package com.cheesecrave.cheesecravedatabase.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
    private Long accountNumber;
    private double totalPrice;
    private String orderQuantity;
    private Set<PurchaseProductDTO> purchaseProducts;

}
