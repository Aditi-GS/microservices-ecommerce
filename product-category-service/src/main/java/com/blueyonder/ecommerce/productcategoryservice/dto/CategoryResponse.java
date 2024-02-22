package com.blueyonder.ecommerce.productcategoryservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryResponse {
    private Integer categoryId;
    private String categoryName;
    private String description;
}
