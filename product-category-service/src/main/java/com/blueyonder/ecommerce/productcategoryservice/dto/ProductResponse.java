package com.blueyonder.ecommerce.productcategoryservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductResponse {
    private Integer productId;
    private String productName;
    private Double price;
    private String description;
}
