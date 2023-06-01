package com.cheesecrave.cheesecravedatabase.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_Id")
    private int productId;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="type")
    private String type;

    @Column(name="quantity")
    private int quantity;

    @Column(name="description")
    private String description;

    //equals, hashcode, and toString
}
