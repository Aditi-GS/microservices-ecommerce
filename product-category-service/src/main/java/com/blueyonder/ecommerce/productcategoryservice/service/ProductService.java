package com.blueyonder.ecommerce.productcategoryservice.service;

import com.blueyonder.ecommerce.productcategoryservice.dto.ProductRequest;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.ProductAlreadyExistsException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.ProductNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.model.Product;

import java.util.List;

public interface ProductService {
    // CREATE
    public Product addProduct(ProductRequest productRequest) throws ProductAlreadyExistsException;

    // RETRIEVE
    List<Product> getAllProducts();
    // Product getProductById(Integer productId) throws ProductNotFoundException;
    Product getProductByName(String productName) throws ProductNotFoundException;
    Product getProductByDescription(String productDescription) throws ProductNotFoundException;

    // UPDATE
    // Product updateProductById(Integer productId, String newName, Double newPrice, String newDescription) throws ProductNotFoundException;

    Product updateProductByName(String productName, Double newPrice, String newDescription) throws ProductNotFoundException;

    Product updateProductByDescription(String productDescription, String newName, Double newPrice) throws ProductNotFoundException;

    // DELETE
    String deleteProductById(Integer productId) throws ProductNotFoundException;

    // LINK WITH CATEGORY
    Product linkWithCategory(String productName, String categoryName) throws CategoryNotFoundException, ProductNotFoundException;
}
