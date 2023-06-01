package com.cheesecrave.cheesecravedatabase.Model;

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
public class Sales {
    @Id
    @GeneratedValue
    @Column(name = "sales_Id")
    private Long salesId;

    @Column(name = "quantity") // number of cheeses sold in order
    private String quantity;

    @Column(name = "total_price")
    private double totalPrice;

}
