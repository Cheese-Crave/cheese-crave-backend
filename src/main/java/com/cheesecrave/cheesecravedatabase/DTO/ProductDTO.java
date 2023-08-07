package com.cheesecrave.cheesecravedatabase.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
    private String name;
    private String image;
    private String description;
    private double price;
    private String milkType;
    private String type;
    private int quantity;
    private String aroma;
    private String texture;
    private Boolean vegetarian;
    private String flavor;
    private int totalRating;
    private int ratingCount;

    public ProductDTO(String name, String image, String description, double price, String milkType, String type, int quantity, String aroma, String texture, Boolean vegetarian, String flavor, int totalRating, int ratingCount) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.milkType = milkType;
        this.type = type;
        this.quantity = quantity;
        this.aroma = aroma;
        this.texture = texture;
        this.vegetarian = vegetarian;
        this.flavor = flavor;
        this.totalRating = totalRating;
        this.ratingCount = ratingCount;
    }
}
