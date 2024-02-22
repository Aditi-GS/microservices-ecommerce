package com.blueyonder.ecommerce.productcategoryservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequest {
    private String productName;
    private Double price;
    private String description;
}
