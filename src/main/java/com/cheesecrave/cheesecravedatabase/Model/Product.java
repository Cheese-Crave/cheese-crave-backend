package com.cheesecrave.cheesecravedatabase.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_Id")
    private Long productId;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="type")
    private String type;

    @Column(name="quantity") // number of cheese in inventory
    private int quantity;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PurchaseProduct> purchaseProducts = new HashSet<>();

}
