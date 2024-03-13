package com.blueyonder.ecommerce.productcategoryservice.controller;

import com.blueyonder.ecommerce.productcategoryservice.dto.ProductRequest;
import com.blueyonder.ecommerce.productcategoryservice.dto.ProductResponse;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.ProductAlreadyExistsException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.ProductNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.service.ProductService;
import com.blueyonder.ecommerce.productcategoryservice.util.ProductUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/ecommerce/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest) throws ProductAlreadyExistsException {
        return ProductUtility.mapToProductResponse(productService.addProduct(productRequest));
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(ProductUtility::mapToProductResponse)
                .toList();
    }

    @GetMapping("/get-product-name/{prodName}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductByName(@PathVariable String prodName) throws ProductNotFoundException {
        return ProductUtility.mapToProductResponse(productService.getProductByName(prodName));
    }

    @GetMapping("/get-product-description/{prodDesc}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductByDescription(@PathVariable String prodDesc) throws ProductNotFoundException {
        return ProductUtility.mapToProductResponse(productService.getProductByDescription(prodDesc));
    }

    @PutMapping("/update-product-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProductByName(@PathVariable String name, @RequestParam(value = "price", required = false) Double price, @RequestParam(value = "desc", required = false) String desc) throws ProductNotFoundException {
        return ProductUtility.mapToProductResponse(productService.updateProductByName(name, price, desc));
    }

    @PutMapping("/update-product-description/{description}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProductByDescription(@PathVariable String description, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "price", required = false) Double price) throws ProductNotFoundException {
        return ProductUtility.mapToProductResponse(productService.updateProductByDescription(description, name, price));
    }

    @DeleteMapping("/delete-product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProduct(@PathVariable Integer id) throws ProductNotFoundException {
        return productService.deleteProductById(id);
    }

    @PostMapping("/product-with-category")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse linkWithCategory(@RequestParam String productName, @RequestParam String categoryName) throws CategoryNotFoundException, ProductNotFoundException {

        try {
            return ProductUtility.mapToProductResponse(productService.linkWithCategory(productName, categoryName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
