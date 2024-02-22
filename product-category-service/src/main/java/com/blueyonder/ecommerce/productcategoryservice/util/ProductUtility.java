package com.blueyonder.ecommerce.productcategoryservice.util;

import com.blueyonder.ecommerce.productcategoryservice.dto.ProductRequest;
import com.blueyonder.ecommerce.productcategoryservice.dto.ProductResponse;
import com.blueyonder.ecommerce.productcategoryservice.model.Product;

public class ProductUtility {
    private ProductUtility() {
    }

    public static Product mapToProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        return product;
    }

    public static ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getProductId());
        productResponse.setProductName(product.getProductName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDescription(product.getDescription());
        return productResponse;
    }
}
