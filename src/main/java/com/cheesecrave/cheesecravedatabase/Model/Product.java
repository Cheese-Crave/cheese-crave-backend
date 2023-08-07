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
    @Column(name="product_id")
    private Long productId;

    @Column(name="name")
    private String name;

    @Column(name="description", columnDefinition = "TEXT")
    private String description;

    @Column(name="image_url")
    private String image;

    @Column(nullable = false, columnDefinition = "DECIMAL(10, 2) DEFAULT 1.00")
    private double price;

    @Column(name="quantity") // number of cheese in inventory
    private int quantity;

    @Column(name="type")
    private String type;

    @Column(name="milk_type")
    private String milkType;

    @Column(name="aroma")
    private String aroma;

    @Column(name="texture")
    private String texture;

    @Column(name="vegetarian")
    private Boolean vegetarian;

    @Column(name="flavor")
    private String flavor;

    @Column(name = "total_rating", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer totalRating;

    @Column(name = "rating_count", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer ratingCount;

    @Transient
    private Integer averageRating;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PurchaseProduct> purchaseProducts = new HashSet<>();
}