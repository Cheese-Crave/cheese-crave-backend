package com.cheesecrave.cheesecravedatabase.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProductDTO {
    private Long productId;
    private Long purchaseId;
    private int quantity;

}
