package com.blueyonder.ecommerce.productcategoryservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductCategoryExceptionHandler {
    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<String> handleProductAlreadyExistsException() {
        return ResponseEntity.badRequest().body("PRODUCT ALREADY EXISTS.");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException() {
        return new ResponseEntity<String>("PRODUCT NOT FOUND.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<String> handleCategoryAlreadyExistsException() {
        return ResponseEntity.badRequest().body("CATEGORY ALREADY EXISTS.");
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException() {
        return new ResponseEntity<String>("CATEGORY NOT FOUND.", HttpStatus.NOT_FOUND);
    }
}
