package com.blueyonder.ecommerce.productcategoryservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products_info")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Double price;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "productId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<Category> categoryList;
}
