package com.blueyonder.ecommerce.productcategoryservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryRequest {
    private String categoryName;
    private String description;
}
