//package com.cheesecrave.cheesecravedatabase.Component;
//
//import com.cheesecrave.cheesecravedatabase.DTO.ProductDTO;
//import com.cheesecrave.cheesecravedatabase.Model.Product;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProductMapper {
//    public ProductDTO toProductDTO(Product product) {
//        if(product == null) {
//            return null;
//        }
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setProductId(product.getProductId());
//        productDTO.setProductName(product.getProductName());
//        productDTO.setProductImage(product.getProductImage());
//        productDTO.setProductDescription(product.getProductDescription());
//        productDTO.setProductPrice(product.getProductPrice());
//        productDTO.setMilkType(product.getMilkType());
//        productDTO.setType(product.getType());
//        productDTO.setQuantity(product.getQuantity());
//        productDTO.setAroma(product.getAroma());
//        productDTO.setTexture(product.getTexture());
//        productDTO.setVegetarian(product.getVegetarian());
//        productDTO.setFlavor(product.getFlavor());
//        return productDTO;
//    }
//}
