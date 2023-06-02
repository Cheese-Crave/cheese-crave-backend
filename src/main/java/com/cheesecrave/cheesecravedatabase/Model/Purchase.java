package com.cheesecrave.cheesecravedatabase.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Purchase {
    @Id
    @GeneratedValue
    @Column(name = "purchase_Id")
    private Long purchaseId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_number", nullable = false)
    private Customer customer;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_quantity") // number of cheeses sold in one order
    private String orderQuantity;

    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PurchaseProduct> purchaseProducts = new HashSet<>();
}